package edu.sjsu.cmpe275.VmDao;

import org.springframework.stereotype.Repository;

import edu.sjsu.cmpe275.VmModel.User;
import edu.sjsu.cmpe275.VmModel.VMDetails;



@Repository
public interface VmDao {
	
	public User getUser(String email);
	public VMDetails[] getVMDetails(String email);
	public VMDetails getVMDetails(String email, String vmname);
}
