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

import com.mkyong.users.model.User;

@Entity
@Table(name = "vmdetails", catalog = "private_cloud", uniqueConstraints = @UniqueConstraint(columnNames = { "vmid", "userid" }))
public class VMDetails {

	private Integer vmid;
	private User user;
	private String vmname;
	private Integer vmstate;

	public VMDetails() {
	}

	public VMDetails(User user, Integer vmid, String vmname, Integer vmstate) {
		this.user = user;
		this.vmid = vmid;
		this.vmname = vmname;
		this.vmstate = vmstate;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "vmid", unique = true, nullable = false)
	public Integer getVmid() {
		return this.vmid;
	}

	public void setVmid(Integer vmid) {
		this.vmid = vmid;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name = "vmname", nullable = false, length = 50)
	public String getVmname() {
		return this.vmname;
	}

	public void setVmname(String vmname) {
		this.vmname = vmname;
	}
	
	@Column(name = "vmstate", nullable = false)
	public String getVmstate() {
		return this.vmstate;
	}

	public void setVmstate(String vmstate) {
		this.vmstate = vmstate;
	}
}
