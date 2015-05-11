package edu.sjsu.cmpe275.VmModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component 
@Entity
@Table(name = "Host", catalog = "cmpe275")
public class Host {
	
	String hostname;
	Integer hoststate;
	String hostram;
	String hostcpu;
	String username;
	String password;
	
	public void Host() {
		
	}
	
	public void Host(String hostname, Integer hoststate, String hostram, String hostcpu) {
		
		this.hostname = hostname;
		this.hoststate = hoststate;
		this.hostcpu = hostcpu;
		this.hostram = hostram;
	}

	@Id
	@Column(name = "hostname", unique = true, 
		nullable = false)
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	@Column(name = "hoststate", 
			nullable = false, length = 1)
	public Integer getHoststate() {
		return hoststate;
	}

	public void setHoststate(Integer hoststate) {
		this.hoststate = hoststate;
	}

	@Column(name = "hostram", 
			length = 20)
	public String getHostram() {
		return hostram;
	}

	public void setHostram(String hostram) {
		this.hostram = hostram;
	}

	@Column(name = "hostcpu", 
			length = 20)
	public String getHostcpu() {
		return hostcpu;
	}

	public void setHostcpu(String hostcpu) {
		this.hostcpu = hostcpu;
	}
	
	@Column(name = "username", 
			nullable = false, length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "password", 
			nullable = false, length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

/*
 * SQL Query:
 * Create table Host (
 * hostname varchr(50) PRIMARY KEY,
 * hoststate int(1),
 * hostram varchar(20),
 * hostcpu varchar(20),
 * username varchar(50),
 * password varchar(50));
*/