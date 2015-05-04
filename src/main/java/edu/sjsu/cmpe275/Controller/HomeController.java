package edu.sjsu.cmpe275.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sjsu.cmpe275.VmDao.VMDaoImpl;
import edu.sjsu.cmpe275.VmDao.VmDao;
import edu.sjsu.cmpe275.VmModel.*;
import edu.sjsu.cmpe275.VmService.*;

@Controller
public class HomeController {
		
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	VmService vmServiceImpl ;
	@Autowired
	User user;
	@Autowired
	VMDetails vMDetails; 
	@Autowired
	VmDao vMDaoImpl;
	
	

	
	//Simply selects the home page to render by returning its name
	//This page will contain signin, signup options
	//Come here after sign out 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		//System.out.println(uRL.toString());
		
	//	vmServiceImpl.createVM(2,"vm1");
	//	vmServiceImpl.createVM(4,"vm2");
	//	vmServiceImpl.createVM(7,"vm3");
	//	vmServiceImpl.powerOn("CentOS_1024MB_2cpu_tmpl1");
	//	vmServiceImpl.powerOFF("CentOS_1024MB_2cpu_tmpl1");
	//	vmServiceImpl.addHost("130.65.133.122", "root", "12!@qwQW");
		
		return "home";
	}
	
	
	//Sign-up: Returns created user
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User signup(@RequestParam(value="firstname") String firstname,
						@RequestParam(value="lastname") String lastname,
						@RequestParam(value="email") String email,
						@RequestParam(value="password") String password) {
		logger.info("Sign-up : ", email);
		
		//Implement user session to login a user
		user = new User(email, firstname, lastname, password, false);
		user = user;

		return user;
	}
	
	//Sign-in: Retrives user details using getUser(email)
	@RequestMapping(value = "/user/{email}", method = RequestMethod.POST)
	public User signin(@PathVariable String email,
						@RequestParam(value="password") String password) {
		logger.info("Sign-in : ", email);
		
		//Implement user session to login a user
		
		user = vMDaoImpl.getUser(email);
		VMDetails vms[] = vMDaoImpl.getVMDetails(email);
		
		return user;
	}
	
	//Create VM: Set default state=0 i.e. stop
	//The templateid=radio button value
	@RequestMapping(value = "/vm/{email}/{vmname}", method = RequestMethod.POST)
	public VMDetails createvm(@PathVariable String email,
						@PathVariable String vmname,
						@RequestParam(value="templateid") Integer templateid) {
		logger.info("Creating VM ", vmname);
		
		//Implement user session to login a user
		if(user != null){
			vMDetails = new VMDetails(vmname, user, 0);		
			//VmService.createVM(templateid,vmname);	
		}
		return vMDetails;
	}
	
	//When user clicks on particular VM it comes here
	@RequestMapping(value = "/vm/{email}/{vmname}", method = RequestMethod.GET)
	public VMDetails viewvm(@PathVariable String email,
						@PathVariable String vmname) {
		logger.info("Showing VM ", vmname);
		
		if(user != null){
			vMDetails = vMDaoImpl.getVMDetails(email, vmname);
		}
		return vMDetails;
	}

	//Change the status of the VM
	@RequestMapping(value = "/vm/{vmname}/{status}", method = RequestMethod.PUT)
	public VMDetails changestate(@PathVariable String vmname,
						@PathVariable String status) {
		logger.info("Powering Off vm ", vmname);
		
		if(vMDetails != null){
			if(status.equals("PowerOff")){
				vmServiceImpl.powerOFF(vmname);
				vMDetails.setVmstate(0);
			}
			else if(status.equals("PowerOn")){
				vmServiceImpl.powerOn(vmname);
				vMDetails.setVmstate(1);
			}
		}
		return vMDetails;
	}
	
	
	/**
	 * @param hostname
	 * @param user
	 * @param password
	 * @return
	 
	@RequestMapping(value = "/host", method = RequestMethod.POST)
	 public String addhost(@RequestParam(value="hostname") String hostname,
			 			@RequestParam(value="user") String user,
			 			@RequestParam(value="password") String password){

		
		vmServiceImpl.addHost(hostname, user, password);
		
		
		return null;
	}*/
	
	
//Closing of Controller	
}
