package edu.sjsu.cmpe275.VmService;

import org.springframework.stereotype.Component;

@Component
public interface VmService {
public void createVM();
public boolean deleteVM(String vmname);
public void getVM();
public void getHost();

}
