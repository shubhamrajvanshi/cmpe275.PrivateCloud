package edu.sjsu.cmpe275.VmModel;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

import edu.sjsu.cmpe275.*;

@SuppressWarnings("unused")
@Component
@Entity
@Table(name = "vmdetails", catalog = "private_cloud", uniqueConstraints = @UniqueConstraint(columnNames = { "vmid", "userid" }))
public class VMDetails {

	private User user;
	private String vmname;
	private Integer vmstate;

	/*public VMDetails() {
	}*/

	public VMDetails(String vmname, User user, Integer vmstate) {
		this.user = user;
		this.vmname = vmname;
		this.vmstate = vmstate;
	}
	
	@Id
	@Column(name = "vmname", nullable = false, length = 50)
	public String getVmname() {
		return this.vmname;
	}

	public void setVmname(String vmname) {
		this.vmname = vmname;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name = "vmstate", nullable = false)
	public Integer getVmstate() {
		return this.vmstate;
	}

	public void setVmstate(Integer vmstate) {
		this.vmstate = vmstate;
	}
}
