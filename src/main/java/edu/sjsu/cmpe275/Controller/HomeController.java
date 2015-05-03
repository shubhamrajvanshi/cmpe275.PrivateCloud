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
		vmServiceImpl.powerOn("vm2");
	//	vmServiceImpl.powerOFF("CentOS_1024MB_2cpu_tmpl1");
	//	vmServiceImpl.addHost("130.65.133.122", "root", "12!@qwQW");
		
		return "home";
	}
	
	/**
	 * Start user login and logout functions
	 */
	
	@RequestMapping(value = "/userlogin", method = RequestMethod.GET)
	public String login(@RequestParam(value="username") String username,
			@RequestParam(value="password") String password) {
		logger.info("Logging user ", username);
		
		//Implement user session to login a user
		
	

		return "User Logged In";
	}
	
	@RequestMapping(value = "/userlogout", method = RequestMethod.GET)
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
	@RequestMapping(value = "/createvm", method = RequestMethod.POST)
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
	@RequestMapping(value = "/poweroff", method = RequestMethod.PUT)
	public String poweroff(@RequestParam(value="vmname") String vmname) {
		logger.info("Powering Off vm ", vmname);
		
		
		vmServiceImpl.powerOFF(vmname);
	

		return "home";
	}
	
	/**
	 * @param vmname
	 * @return
	 */
	@RequestMapping(value = "/poweron", method = RequestMethod.PUT)
	public String poweron(@RequestParam(value="vmname") String vmname) {
		logger.info("Powering On vm ", vmname);
		
		
		vmServiceImpl.powerOn(vmname);
	

		return "home";
	}
	
	/**
	 * @param hostname
	 * @param user
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/addhost", method = RequestMethod.POST)
	 public String addhost(@RequestParam(value="hostname") String hostname,@RequestParam(value="user") String user,
			 			   @RequestParam(value="password") String password)	{

		
		vmServiceImpl.addHost(hostname, user, password);
		
		
		return null;
		}
	
	
//Closing of Controller	
}
