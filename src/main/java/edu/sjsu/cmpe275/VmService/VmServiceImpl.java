package edu.sjsu.cmpe275.VmService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vmware.vim25.DuplicateName;
import com.vmware.vim25.HostConnectSpec;
import com.vmware.vim25.InvalidName;
import com.vmware.vim25.InvalidProperty;
import com.vmware.vim25.ResourceInUse;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.VirtualMachineCloneSpec;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.VirtualMachineQuestionInfo;
import com.vmware.vim25.VirtualMachineQuickStats;
import com.vmware.vim25.VirtualMachineRelocateSpec;
import com.vmware.vim25.VirtualMachineSummary;
import com.vmware.vim25.mo.ComputeResource;
import com.vmware.vim25.mo.Datacenter;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ResourcePool;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;

@Component
public class VmServiceImpl implements VmService{
	//@Autowired
	private static ServiceInstance serviceInstance;	
	
	private static Logger LOGGER = LoggerFactory.getLogger("VmServiceImpl");
	
	@Autowired
	public VmServiceImpl(ServiceInstance serviceInstance)
	{
		this.serviceInstance = serviceInstance ;
	}
	
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
	public void createVM(int selection,String vmname) {
		// TODO Auto-generated method stub
		try{
		String template= null;
	//	Selecting the right template as per selection passed
		switch(selection){
		case 1:
			template = "CentOS_1024MB_2cpu_tmpl";
			break;
		case 2:
			template = "Ubuntu_1024MB_1cpu_tmpl";
			break;
		case 3:
			template = "Ubuntu_512MB_2cpu_tmpl";
			break;
		case 4:
			template = "Ubuntu_512MB_1cpu_tmpl";
			break;
		case 5:
			template = "Ubuntu_512MB_2cpu_tmpl";
			break;
		case 6:
			template = "Windows_1GB_1cpu_tmpl";
			break;
		case 7:
			template = "Windows_1GB_2cpu_tmpl";
			break;
		case 8:
			template = "Windows_2GB_2cpu_tmpl";
			break;
		}
		// Gets the MOR of the template to be used to create the vm
		VirtualMachine vm = (VirtualMachine) new InventoryNavigator(serviceInstance.getRootFolder()).searchManagedEntity("VirtualMachine", template);
		
		
		ManagedEntity [] mes =  new InventoryNavigator(serviceInstance.getRootFolder()).searchManagedEntities("HostSystem");
		ManagedEntity [] mes1 =  new InventoryNavigator(serviceInstance.getRootFolder()).searchManagedEntities("ResourcePool");
		Datacenter dc = (Datacenter) serviceInstance.getSearchIndex()
				.findByInventoryPath("T24-DC");
		int hosttouse = new Random().nextInt(mes.length); // Used to select Random host as managed entity
		
		HostSystem host = (HostSystem) mes[hosttouse];
		System.out.println("Creating vm from template " + vm.getName() + " on " + host.getName());
		ResourcePool rp = (ResourcePool) mes1[hosttouse];   
		
		//Vm's relocation specification
		VirtualMachineRelocateSpec vmrs = new VirtualMachineRelocateSpec();
		 		vmrs.setHost(host.getMOR() );  // to deploy vm on selected host
			   	vmrs.setPool(rp.getMOR());	   // deploy on resource	
			   	
						
		//vm to be deployed's clone specifications
		VirtualMachineCloneSpec vmclspec = new VirtualMachineCloneSpec();
		vmclspec.setLocation(vmrs);
		vmclspec.setPowerOn(true);
		vmclspec.setTemplate(false);
		
		Task task = vm.cloneVM_Task((Folder) dc.getVmFolder(), vmname,vmclspec);
		LOGGER.info("Launching the VM clone task. "
				+ "Please wait ...");

		if (task.waitForTask() == task.SUCCESS) {
			LOGGER.info("VM got deployed successfully.");
			System.out.println("VM got deployed successfully.");
		} else {
			LOGGER.info("Failure -: VM deployment failed");
			System.out.println("Failure -: VM deployment failed");
			}
		}
		catch (InvalidProperty e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeFault e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public void getVM(String vmname) {
		//System.out.println(serviceInstance.getServerConnection().getUsername());
	//	Datacenter dc = null ;
	//	System.out.println(serviceInstance.getRootFolder().getMOR().getType()+" "+serviceInstance.getRootFolder().getMOR().get_value()+" "+ serviceInstance.getRootFolder().getMOR().getVal() );
				 VirtualMachine vm;
				 try {
						vm = (VirtualMachine) new InventoryNavigator(serviceInstance.getRootFolder()).searchManagedEntity("VirtualMachine", "CentOS_1024MB_2cpu_tmpl1");
						System.out.println(vm.getName());
				 				
				 				
				 				} catch (InvalidProperty e) {
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

	@Override
	public boolean powerOn(String vmname) {

		try 
		{
			
			Folder rootFolder = serviceInstance.getRootFolder() ;
			VirtualMachine vm = (VirtualMachine) new InventoryNavigator(
					rootFolder).searchManagedEntity("VirtualMachine", vmname);

			Task task = vm.powerOnVM_Task(null);
			if (task.waitForTask() == Task.SUCCESS) {
				System.out.println(vmname+" powered on");
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

	@Override
	public  boolean powerOFF(String vmname) {

		try {
			

			Folder rootFolder = serviceInstance.getRootFolder();
			VirtualMachine vm = (VirtualMachine) new InventoryNavigator(
					rootFolder).searchManagedEntity("VirtualMachine", vmname);

			Task task = vm.powerOffVM_Task();

			if (task.waitForTask() == Task.SUCCESS) {
				System.out.println(vmname + " powered off");
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
	public void getHost(String hostName) {
		// TODO Auto-generated method stub
		try {
			HostSystem vm = (HostSystem) new InventoryNavigator(serviceInstance.getRootFolder()).searchManagedEntity("HostSystem", hostName);
		} catch (InvalidProperty e) {
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

	



}
