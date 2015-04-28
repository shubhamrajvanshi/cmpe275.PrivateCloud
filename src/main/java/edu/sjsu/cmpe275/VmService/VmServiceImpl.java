package edu.sjsu.cmpe275.VmService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vmware.vim25.DuplicateName;
import com.vmware.vim25.InvalidName;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.VirtualMachineQuestionInfo;
import com.vmware.vim25.VirtualMachineQuickStats;
import com.vmware.vim25.VirtualMachineSummary;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;

@Component
public class VmServiceImpl implements VmService{
	@Autowired
	private static ServiceInstance serviceInstance;	
	
	private static Logger LOGGER = LoggerFactory.getLogger("VmServiceImpl");
	
	
	/**
	 * @return the serviceInstance
	 */
	public ServiceInstance getServiceInstance() {
		return serviceInstance;
	}

	/**
	 * @param serviceInstance the serviceInstance to set
	 */
	public void setServiceInstance(ServiceInstance serviceInstance) {
		this.serviceInstance = serviceInstance;
	}

	@Override
	public void createVM() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteVM(String vmname) {
		// TODO Auto-generated method stub
		try {
			
			Folder rootFolder = serviceInstance.getRootFolder();
			VirtualMachine vm = (VirtualMachine) new InventoryNavigator(
					rootFolder).searchManagedEntity("VirtualMachine", vmname);

			Task task = vm.destroy_Task();

			if (task.waitForTask() == Task.SUCCESS) {
				LOGGER.info(vmname + " destroyed off");
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	

	@Override
	public void getVM() {
		// TODO Auto-generated method stub
		try {
		//	ServiceInstance serviceInstance1 = new ServiceInstance(new URL("https://130.65.132.124/sdk"),"administrator","12!@qwQW",true);
			//System.out.println(serviceInstance.getServerConnection().getUrl().toString());
			
			//System.out.println(serviceInstance.getServerConnection().getUsername());
			System.out.println(serviceInstance.getRootFolder().getMOR().getType()+serviceInstance.getRootFolder().getMOR().get_value()+" "+ serviceInstance.getRootFolder().getMOR().getVal() );
			
			if(serviceInstance.getRootFolder().createDatacenter("testdc") != null);
			System.out.println("Datacenter Created");
			serviceInstance.getRootFolder().getMOR().set_value("VirtualMachine");
			System.out.println(serviceInstance.getRootFolder().getMOR().getType()+" "+ serviceInstance.getRootFolder().getMOR().getVal());
			VirtualMachine vm = new VirtualMachine(serviceInstance.getServerConnection(), serviceInstance.getRootFolder().getMOR());
			System.out.println(vm.getSummary().getGuest().getIpAddress());
			serviceInstance.getServerConnection().logout();
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DuplicateName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static boolean powerON(String vmname) {

		try 
		{
			
			Folder rootFolder = serviceInstance.getRootFolder();
			VirtualMachine vm = (VirtualMachine) new InventoryNavigator(
					rootFolder).searchManagedEntity("VirtualMachine", vmname);

			Task task = vm.powerOnVM_Task(null);
			if (task.waitForTask() == Task.SUCCESS) {
				LOGGER.info(vmname + " powered on");
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public static boolean powerOFF(String vmname) {

		try {
			

			Folder rootFolder = serviceInstance.getRootFolder();
			VirtualMachine vm = (VirtualMachine) new InventoryNavigator(
					rootFolder).searchManagedEntity("VirtualMachine", vmname);

			Task task = vm.powerOffVM_Task();

			if (task.waitForTask() == Task.SUCCESS) {
				LOGGER.info(vmname + " powered off");
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	@Override
	public void getHost() {
		// TODO Auto-generated method stub
		
	}

}
