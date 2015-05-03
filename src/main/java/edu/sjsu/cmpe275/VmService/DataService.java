package edu.sjsu.cmpe275.VmService;

import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Random;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.vmware.vim25.ComputeResourceConfigSpec;
import com.vmware.vim25.HostConnectSpec;
import com.vmware.vim25.InvalidProperty;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.VirtualMachineCloneSpec;
import com.vmware.vim25.VirtualMachineRelocateSpec;
import com.vmware.vim25.mo.Datacenter;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ResourcePool;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;

import edu.sjsu.cmpe275.VmDao.*;
import edu.sjsu.cmpe275.VmModel.*;

public class DataService {

	@Transactional(readOnly=true)
	@Override
	public User loadUser(String email) throws Exception {
	
		User user = vmDao.getUser(email);
		List<VMDetails> instances = getUserInstances(user.getVmdetails());

		return getUserWithInstances(user, instances);
		
	}
	
	private User getUserWithInstances(User user, Set<VMDetails> instances){
		
		User temp = new User(user.getEmail(), user.getFirstname(), user.getLastname(), user.getPassword(), user.isadmin());
		temp.setVmdetails(instances);
		return temp;
	}
	
	private List<GrantedVms> getUserInstances(Set<VMdetails> instances){
		
		Set<GrantedInstances> ginstances = new HashSet<GrantedInstances>();

		for (VMdetails details : VMdetails) {
			ginstances.add(new SimpleGrantedVms(details.getVmname()));
		}

		List<GrantedInstances> Result = new ArrayList<GrantedInstances>(ginstances);

		return Result;
	}
	
	private static Logger LOGGER = LoggerFactory.getLogger("VmServiceImpl");
}
