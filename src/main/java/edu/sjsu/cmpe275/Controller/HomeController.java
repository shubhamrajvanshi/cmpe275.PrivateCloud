package edu.sjsu.cmpe275.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sjsu.cmpe275.VmService.VmService;

/**
 * Handles requests for the application home page.
 */
/**
 * @author Shubham
 *
 */

@Controller
public class HomeController {
	
	private User temp_user;
	private cnt = 0; 
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	VmService vmServiceImpl ;
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
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
		logger.info("Sign-up : ", username);
		
		//Implement user session to login a user
		temp_user = new User(cnt++, email, password, FALSE);	

		return temp_user;
	}
	
	//Sign-in: Retrives user details using getUser(email)
	@RequestMapping(value = "/user/{email}", method = RequestMethod.POST)
	public User signup(@RequestParam(value="password") String password) {
		logger.info("Sign-in : ", username);
		
		//Implement user session to login a user
		temp_user = getUser(email);
		
		return temp_user;
	}
	
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.PUT)
	public String logout(@RequestParam(value="username") String username
			) {
		logger.info("Logging out user ", username);
		
		//Implement user session to login a user
		
	

		return "User logged out";
	}
	
	/**
	 * Start of vm and host controller functions
	 */
	
	
	/**
	 * @param templateid
	 * @param vmname
	 * @return 
	 */
	@RequestMapping(value = "/vm", method = RequestMethod.POST)
	public String createvm(@RequestParam(value="templateid") int templateid,
						   @RequestParam(value="vmname") String vmname) {
		logger.info("Creating VM with templateid ", templateid);
		
		
		vmServiceImpl.createVM(templateid,vmname);
	

		return "home";
	}
		
	/**
	 * @param vmname
	 * @return
	 */
	@RequestMapping(value = "/vm/{status}", method = RequestMethod.PUT)
	public String poweroff(@RequestParam(value="vmname") String vmname) {
		logger.info("Powering Off vm ", vmname);
		
		
		vmServiceImpl.powerOFF(vmname);
	

		return "home";
	}
	
	/**
	 * @param vmname
	 * @return
	 */
	/*Not required
	 * Will be handled in "/vm/{status}"
	 * @RequestMapping(value = "/poweron", method = RequestMethod.PUT)
	 
	public String poweron(@RequestParam(value="vmname") String vmname) {
		logger.info("Powering On vm ", vmname);
		
		
		vmServiceImpl.powerOn(vmname);
	

		return "home";
	}*/
	
	/**
	 * @param hostname
	 * @param user
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/host", method = RequestMethod.POST)
	 public String addhost(@RequestParam(value="hostname") String hostname,@RequestParam(value="user") String user,
			 			   @RequestParam(value="password") String password)	{

		
		vmServiceImpl.addHost(hostname, user, password);
		
		
		return null;
		}
	
	
//Closing of Controller	
}
