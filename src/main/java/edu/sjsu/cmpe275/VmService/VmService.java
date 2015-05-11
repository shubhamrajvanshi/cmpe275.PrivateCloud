package edu.sjsu.cmpe275.VmService;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.sjsu.cmpe275.VmModel.Host;
import edu.sjsu.cmpe275.VmModel.User;

@SuppressWarnings("unused")
@Component
public interface VmService {
// VM functions	
public void createVM(Integer selection, String vmname);
public boolean deleteVM(String vmname);
public void getVM(String vmname);
public boolean powerOFF(String vmname);

// Host functions
public List<Host> getHost();
public boolean powerOn(String string);
public void getHost(String hostName);
public boolean addHost(String hostname, String user ,String password);


}
