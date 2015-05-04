package edu.sjsu.cmpe275.VmService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.cmpe275.VmDao.VmDao;
import edu.sjsu.cmpe275.VmModel.User;
import edu.sjsu.cmpe275.VmModel.VMDetails;


@Service("dataService")
public class DataService {
	
//	@Autowired
	private VmDao vMDaoImpl;

	@Transactional(readOnly=true)
	public User loadUser(String email) throws Exception {
	
		User user = vMDaoImpl.getUser(email);
		@SuppressWarnings("unused")
		List<String> vms = loadInstances(user.getVmdetails());
		return user;
		
	}
	
	/*private User buildUser(User tu, VMDetails tvm){
		
		return(new User(tu.getEmail(), tu.getFirstname(), tu.getLastname(), tu.getPassword(), tu.getVmdetails()));
	}*/
	
	private List<String> loadInstances(Set<VMDetails> vms){
		
		Set<String> vmnames = new HashSet<String>();
		for(VMDetails vm : vms){
			vmnames.add(new String(vm.getVmname()));
		}
		List<String> result = new ArrayList<String>(vmnames);
		return result;
	}	
}
