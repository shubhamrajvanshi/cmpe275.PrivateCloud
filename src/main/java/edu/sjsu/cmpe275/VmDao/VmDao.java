package edu.sjsu.cmpe275.VmDao;

public interface VmDao {
	
	public User getUser(Integer id);
	public VMDetails getVMDetails(Integer id);
	public VMDetails getVMDetails(Integer id, Integer vmid);
}
