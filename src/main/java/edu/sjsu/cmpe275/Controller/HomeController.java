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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.VmDao.VmDao;
import edu.sjsu.cmpe275.VmModel.Host;
import edu.sjsu.cmpe275.VmModel.User;
import edu.sjsu.cmpe275.VmModel.VMDetails;
import edu.sjsu.cmpe275.VmModel.Vmhardware;
import edu.sjsu.cmpe275.VmService.VmService;

@Controller
@SessionAttributes("usersession")
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
	@Autowired
    private MailSender mailSender;
	@Autowired
	Host host ;

	
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
	
		return "index";
	}
	
	@RequestMapping(value = {"/about","/*/about"}, method = RequestMethod.GET)
	public String about() {
		
		return "about";
	}
	
	@RequestMapping(value = {"/services","/*/services"}, method = RequestMethod.GET)
	public String services() {
		
		return "services";
	}
	
	@RequestMapping(value = {"/signin","/*/signin"}, method = RequestMethod.GET)
	public String sigin(@ModelAttribute User user){
		System.out.println("inside signin get");
			return "signin";
	}
	
	@RequestMapping(value = {"/signup","/*/signup"}, method = RequestMethod.GET)
	public String signup(@ModelAttribute User user){
		System.out.println("inside signup get");
	    
		return "signup";
	}
	
	@RequestMapping(value = {"/logout","/*/logout"}, method = RequestMethod.GET)
	public String logout() {
		
		return "logout";
	}
	
	@RequestMapping(value = {"/index","/**/index"}, method = RequestMethod.GET)
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
	        message.setText("Thanks for registering with Team 7"
	        		+ "\nYour login details are:\nUsername:" + user.getEmail()+"\nPassword:"+user.getPassword()+
	        		"\nThank You\nShubham Rajvanshi");
	        mailSender.send(message);
			return new ModelAndView("index");
			
		}
		else
			return new ModelAndView("signup");
	}
	
		
	//Sign-in: Retrives user details using getUser(email)
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(@ModelAttribute(value="user") User user) {
		logger.info("Sign-in : ", user.getEmail());
		
		//Implement user session to login a user
		this.user = vMDaoImpl.getUser(user.getEmail());
		System.out.println(user.getFirstname()+ user.getLastname()+ "entered password " + user.getPassword() );
		System.out.println("value from database"+ this.user.getEmail()+ " "+ this.user.getPassword());
		ModelAndView model = new ModelAndView();
		if(this.user.getEmail().equals(user.getEmail()) && this.user.getPassword().equals(user.getPassword())){
		 if(this.user.getIsadmin()==false)
			{
			
				model.setViewName("user");
				return "redirect:/user";
			}
		 else  {
		
			model.setViewName("admin");
			return "redirect:/admin";
			}
		}
		
		model.setViewName("signin");	
		return "signin";
	}
	
	
	@RequestMapping(value="/admin" , method=RequestMethod.GET)
	public ModelAndView admin(){
		
		System.out.println("inside admin get");
		List<VMDetails> vms = vMDaoImpl.getAllVMs();
		List<Host> hosts = vmServiceImpl.getHost();
		System.out.println(vms.size());
		System.out.println(vms.get(0).getVmname());
		ModelAndView model = new ModelAndView();
		model.addObject(this.user);
		model.addObject("hosts", hosts);
		model.addObject("vms",vms);
		model.setViewName("admin");
		return model;
	}
	
	//To display add host page
	@RequestMapping(value="/admin/host", method=RequestMethod.GET)
	public String host(@ModelAttribute(value="host") Host host){
		System.out.println("inside addhost");
		return "addhost";
	}
	
	@RequestMapping(value="/user" , method=RequestMethod.GET)
	public ModelAndView user(){
		
		System.out.println("inside user get");
		List<VMDetails> vms = vMDaoImpl.getVMDetails(this.user.getEmail());
		//System.out.println("Number of VMs for "+ this.user.getEmail() + ": " + vms.size());
		
		ModelAndView model = new ModelAndView();
		model.addObject(this.user);
		
		model.addObject("vms",vms);
		model.setViewName("user");
		return model;
	}
	 
	//To display create new vm page
	@RequestMapping(value="/user/newvm", method=RequestMethod.GET)
	public String newvm(@ModelAttribute(value="vm")VMDetails vMDetails ){
		System.out.println("inside create vm get");
		return "createvm";
	}
		
	
	//Create VM: Set default state=0 i.e. stop
	//The templateid=radio button value
	@RequestMapping(value = "/user/newvm", method = RequestMethod.POST)
	public String createvm(@ModelAttribute(value="vm")VMDetails vMDetails, @RequestParam("template") int template ) {
		System.out.println("inside newvm post");
		logger.info("Creating VM ", vMDetails.getVmname());
		vMDetails.setUser(user);
		//Implement user session to login a user
		if(user != null){
			vMDetails.setVmstate(1);
			vMDaoImpl.setVM(vMDetails)	;	
			vmServiceImpl.createVM(template,vMDetails.getVmname());	
		}
		return "redirect:/user";
	}
	
	//When user clicks on particular VM it comes here
	@RequestMapping(value = {"/user/{email}/{vmname}","/admin/{email}/{vmname}"}, method = RequestMethod.GET)
	public ModelAndView viewvm(@PathVariable String email,
						@PathVariable String vmname) {
		logger.info("Showing VM ", vmname);
		
		//if(user != null){
			vMDetails = vMDaoImpl.getVMDetails(email, vmname);
			Vmhardware vmhardware = vmServiceImpl.getVM(vmname);
			System.out.println("inside vmdetails - user- vms : ");
		//}
			ModelAndView model = new ModelAndView();
			//model.addObject(this.user);
			model.addObject("vmhardware", vmhardware);
			model.addObject("vms",vMDetails);
			model.setViewName("vmdetails");
			return model;
	}

	//Change the status of the VM
	@RequestMapping(value = {"/user/{email}/{vm}/{status}","/admin/{email}/{vm}/{status}"}, method = RequestMethod.GET)
	public String changeState(@PathVariable String email,
						@PathVariable String vm,
						@PathVariable String status) {
		logger.info("Powering Off vm ", vm);
		System.out.println("inside changeState" + status);
		if(vMDetails != null){
			//if 1: Change state to poweroff
			if(status.equals("1")){
			vmServiceImpl.powerOFF(vm);
				vMDetails.setVmstate(0);
			}
			else if(status.equals("0")){
				vmServiceImpl.powerOn(vm);
				vMDetails.setVmstate(1);
			}
			vMDaoImpl.changeVmState(vMDetails);
		}
		
		
		return "redirect:/user";
	}
	
	
	/**
	 * @param hostname
	 * @param user
	 * @param password
	 * @return admin page
	 **/
	@RequestMapping(value = "/admin/host", method = RequestMethod.POST)
	 public String addhost(@ModelAttribute(value="host") Host host){
		
		if(vmServiceImpl.addHost(host.getHostname(), host.getUsername(), host.getPassword())){
			System.out.println("Host added successfully");
			return "redirect:/admin";
		}
		else{
			System.out.println("error adding host");
			return "redirect:/admin/host";
		}
			
	}
	
	
//Closing of Controller	
}
