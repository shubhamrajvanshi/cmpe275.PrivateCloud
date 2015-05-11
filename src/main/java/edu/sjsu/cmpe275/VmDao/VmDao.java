package edu.sjsu.cmpe275.VmDao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.sjsu.cmpe275.VmModel.Host;
import edu.sjsu.cmpe275.VmModel.User;
import edu.sjsu.cmpe275.VmModel.VMDetails;



@Repository
public interface VmDao {
	public boolean setUser(User user);
	public User getUser(String email);
	public List<VMDetails> getVMDetails(String email);
	public VMDetails getVMDetails(String email, String vmname);
	public List<VMDetails> getAllVMs();
	public boolean setVM(VMDetails vm);
	void changeVmState(VMDetails vm);
	boolean setHost(Host host);
}
