package edu.sjsu.cmpe275.Controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.MailException;


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
	@Autowired
    private MailSender mailSender;
	

	
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
		return "redirect:signup";
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
	public String sigin(@ModelAttribute User user){
		System.out.println("inside signin get");
	
		return "signin";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(@ModelAttribute User user){
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
	
	@RequestMapping(value = "/processsignup", method = RequestMethod.POST)
	public ModelAndView processsignup(@ModelAttribute(value="user") User user)
	{
		System.out.println("processing signup");
		if(vMDaoImpl.setUser(user)){
			System.out.println("sending mail");
			SimpleMailMessage message = new SimpleMailMessage();
			message.setSentDate(new Date());
			message.setFrom("team7@gmail.com");
			message.setTo(new String[] {"bharti.15a@gmail.com","priyankakarpe12@gmail.com","dixitapurva6@gmail.com"});
			message.setSubject("User Created from spring");
	        message.setText("If you got this then it means I was able to create a new user from our project and send email."
	        		+ "I won't be there at 1 pm now as I am going to sleep now. Cheers! we will make it work."
	        		+ "\nUser details are:\nUsername:" + user.getEmail()+"\nPassword:"+user.getPassword()+
	        		"\nThank You\nShubham Rajvanshi");
	        mailSender.send(message);
			return new ModelAndView("index");
			
		}
		else
			return new ModelAndView("signup");
	}
	
	
	
	
	//Sign-in: Retrives user details using getUser(email)
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView signin(@ModelAttribute(value="user") User user) {
		logger.info("Sign-in : ", user.getEmail());
		
		//Implement user session to login a user
		this.user = vMDaoImpl.getUser(user.getEmail());
		System.out.println(user.getFirstname()+ user.getLastname()+ "entered password " + user.getPassword() );
		System.out.println("value from database"+ this.user.getEmail()+ " "+ this.user.getPassword());
		ModelAndView model = new ModelAndView();
		//VMDetails vms[] = vMDaoImpl.getVMDetails(user.getEmail());
		/*List <String> list = new ArrayList<String>(5);
		Set <VMDetails> u = new HashSet<VMDetails>();
		for(int i = 0; i < vms.length-1; i++){
			//u.add(vms[i]);
			list.add(vms[i].getVmname());
			System.out.println(vms[i].getVmname());
		}
		System.out.println("List = " + list.toString());
		//user.setVmdetails(u);*/
		
		if(this.user.getEmail().equals(user.getEmail()) && this.user.getPassword().equals(user.getPassword())){
			
		
		if(this.user.getIsadmin()==false)
			{
			//	model.addObject(user);
			//	model.addObject(vms);
				model.setViewName("user");
				return model;
			}
		else  {
		//	model.addObject(user);
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
