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

import edu.sjsu.cmpe275.VmDao.VmDao;
import edu.sjsu.cmpe275.VmModel.*;
import edu.sjsu.cmpe275.VmService.*;

@Controller
public class HomeController {
	
	private User temp_user=null, user_session=null;
	private VMDetails temp_vm=null, vm_session=null;
	private int cnt = 0; 
	private VmDao vmdao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	VmService vmServiceImpl ;
	

	
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
		temp_user = new User(email, firstname, lastname, password, false);
		user_session = temp_user;

		return temp_user;
	}
	
	//Sign-in: Retrives user details using getUser(email)
	@RequestMapping(value = "/user/{email}", method = RequestMethod.POST)
	public User signin(@PathVariable String email,
						@RequestParam(value="password") String password) {
		logger.info("Sign-in : ", email);
		
		//Implement user session to login a user
		vmdao = new VMDaoImpl();
		temp_user = vmdao.getUser(email);
		VMDetails vms[] = vmdao.getVMDetails(email);
		user_session = temp_user;
		
		return temp_user;
	}
	
	//Create VM: Set default state=0 i.e. stop
	//The templateid=radio button value
	@RequestMapping(value = "/vm/{email}/{vmname}", method = RequestMethod.POST)
	public VMDetails createvm(@PathVariable String email,
						@PathVariable String vmname,
						@RequestParam(value="templateid") Integer templateid) {
		logger.info("Creating VM ", vmname);
		
		//Implement user session to login a user
		if(user_session != null){
			temp_vm = new VMDetails(vmname, user_session, 0);		
			VmService.createVM(templateid,vmname);		
			vm_session = temp_vm;
		}
		return temp_vm;
	}
	
	//When user clicks on particular VM it comes here
	@RequestMapping(value = "/vm/{email}/{vmname}", method = RequestMethod.GET)
	public VMDetails viewvm(@PathVariable String email,
						@PathVariable String vmname) {
		logger.info("Showing VM ", vmname);
		
		if(user_session != null){
			vm_session = vmdao.getVMDetails(email, vmname);
		}
		return vm_session;
	}

	//Change the status of the VM
	@RequestMapping(value = "/vm/{vmname}/{status}", method = RequestMethod.PUT)
	public VMDetails changestate(@PathVariable String vmname,
						@PathVariable String status) {
		logger.info("Powering Off vm ", vmname);
		
		if(vm_session){
			if(status.equals("PowerOff")){
				vmServiceImpl.powerOFF(vmname);
				vm_session.setVmstate(0);
			}
			else if(status.equals("PowerOn")){
				vmServiceImpl.powerOn(vmname);
				vm_session.setVmstate(1);
			}
		}
		return vm_session;
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
