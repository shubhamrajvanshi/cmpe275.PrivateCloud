package edu.sjsu.cmpe275.VmDao;

import edu.sjsu.cmpe275.VmModel.*;

public interface VmDao {
	
	public User getUser(String email);
	public VMDetails[] getVMDetails(String email);
	public VMDetails getVMDetails(String email, String vmname);
}
