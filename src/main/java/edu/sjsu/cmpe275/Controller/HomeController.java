package edu.sjsu.cmpe275.Controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.VmDao.VmDao;
import edu.sjsu.cmpe275.VmModel.User;
import edu.sjsu.cmpe275.VmModel.Luser;
import edu.sjsu.cmpe275.VmModel.VMDetails;
//import edu.sjsu.cmpe275.VmService.VmService;



@Controller
public class HomeController {
		
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	@Autowired
//	VmService vmServiceImpl ;
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
//	@ResponseBody
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
	//	user=vMDaoImpl.getUser("s@s.com");
	//	System.out.println("got  " +user.getFirstname()+" "+ user.getIsadmin());
	//	user = new User("pri@sjsu.edu", "Pri", "Karpe", "ppp", false);
//		return user;
		return "vmdetails";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		
		return "about";
	}
	@RequestMapping(value = "/services", method = RequestMethod.GET)
	public String services() {
		
		return "services";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String sigin(){
		System.out.println("inside signin get");
	
		return "signin";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(){
		System.out.println("inside signup get");
	
		return "signup";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		
		return "logout";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		
		return "index";
	}
	//Sign-up: Returns created user
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User signup(@RequestParam(value="firstname") String firstname,
						@RequestParam(value="lastname") String lastname,
						@RequestParam(value="email") String email,
						@RequestParam(value="password") String password) {
		logger.info("Sign-up : ", email);
		System.out.println("inside creating user");
		//Implement user session to login a user
		user = new User(email, firstname, lastname, password, false);
		return user;
	}
	
	
	
	
	//Sign-in: Retrives user details using getUser(email)
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView signin(@RequestParam(value="email") String email,@RequestParam(value="password") String password) {
		logger.info("Sign-in : ", email);
		
		//Implement user session to login a user
		user = vMDaoImpl.getUser(email);
		System.out.println(user.getFirstname()+ user.getLastname()+ user.getPassword() + "entered password " + password);
		ModelAndView model = new ModelAndView();
		VMDetails vms[] = vMDaoImpl.getVMDetails(email);
		/*List <String> list = new ArrayList<String>(5);
		Set <VMDetails> u = new HashSet<VMDetails>();
		for(int i = 0; i < vms.length-1; i++){
			//u.add(vms[i]);
			list.add(vms[i].getVmname());
			System.out.println(vms[i].getVmname());
		}
		System.out.println("List = " + list.toString());
		//user.setVmdetails(u);*/
		
		if(email.equals(user.getEmail()) && password.equals(user.getPassword())){
			
		
		if(user.getIsadmin()==false)
			{
				model.addObject(user);
				model.addObject(vms);
				model.setViewName("user");
				return model;
			}
		else  {
			model.addObject(user);
			model.setViewName("admin");
			return model;
			}
		}
		
		model.setViewName("sigin");	
		return model;
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
	//			vmServiceImpl.powerOFF(vmname);
				vMDetails.setVmstate(0);
			}
			else if(status.equals("PowerOn")){
	//			vmServiceImpl.powerOn(vmname);
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
