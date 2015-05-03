package edu.sjsu.cmpe275.VmModel;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.sjsu.cmpe275.*;
 
@Entity
@Table(name = "user", catalog = "private_cloud")
public class User {
	
	String email;
	String firstname;
	String lastname;
	String password;
	boolean isadmin;
	private Set<VMDetails> vmDetails = new HashSet<VMDetails>(0);
	
	public User() {
	}
 
	public User(Integer id, String username, String password, boolean isadmin) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.isadmin = isadmin;
	}
 
	@Id
	@Column(name = "id", unique = true, 
		nullable = false)
	public String getId() {
		return this.id;
	}
 
	public void setId(String id) {
		this.id = id;
	}
 
	@Column(name = "username", 
			nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}
	 
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "password", 
		nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
	@Column(name = "isadmin", nullable = false)
	public boolean isadmin() {
		return this.isadmin;
	}
 
	public void setisadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<VMDetails> getVmdetails() {
		return this.vmDetails;
	}
 
	public void setVmdetails(Set<VMDetails> vmDetails) {
		this.vmDetails = vmDetails;
	}
}
