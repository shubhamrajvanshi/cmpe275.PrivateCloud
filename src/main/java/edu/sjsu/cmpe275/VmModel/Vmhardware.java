package edu.sjsu.cmpe275.VmModel;

import org.springframework.stereotype.Component;

@Component
public class Vmhardware {
	private String vmname;
	private int cpu;
	private int memory;
	private String guestfullname;
	private String ipaddress;
	
	/**
	 * @return the ipaddress
	 */
	public String getIpaddress() {
		return ipaddress;
	}
	/**
	 * @param ipaddress the ipaddress to set
	 */
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	/**
	 * @return the vmname
	 */
	public String getVmname() {
		return vmname;
	}
	/**
	 * @param vmname the vmname to set
	 */
	public void setVmname(String vmname) {
		this.vmname = vmname;
	}
	/**
	 * @return the cpu
	 */
	public int getCpu() {
		return cpu;
	}
	/**
	 * @param i the cpu to set
	 */
	public void setCpu(int i) {
		this.cpu = i;
	}
	/**
	 * @return the memory
	 */
	public int getMemory() {
		return memory;
	}
	/**
	 * @param i the memory to set
	 */
	public void setMemory(int i) {
		this.memory = i;
	}
	/**
	 * @return the guestfullname
	 */
	public String getGuestfullname() {
		return guestfullname;
	}
	/**
	 * @param guestfullname the guestfullname to set
	 */
	public void setGuestfullname(String guestfullname) {
		this.guestfullname = guestfullname;
	}
	

}
