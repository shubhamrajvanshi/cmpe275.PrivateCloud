package edu.sjsu.cmpe275.VmService;

import org.springframework.stereotype.Component;

@Component
public interface VmService {
// VM functions	
public void createVM(int selection, String vmname);
public boolean deleteVM(String vmname);
public void getVM(String vmname);
public boolean powerOFF(String vmname);

// Host functions
//public void getHost();
public boolean powerOn(String string);
public void getHost(String hostName);
public boolean addHost(String hostname, String user ,String password);






}
