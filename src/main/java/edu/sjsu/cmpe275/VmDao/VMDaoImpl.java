package edu.sjsu.cmpe275.VmDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sjsu.cmpe275.VmModel.*;

@Repository
public class VMDaoImpl implements VmDao{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	
	@Override
	public User getUser(String email){
		
		List<User> user = new ArrayList<User>();

		user = sessionFactory.getCurrentSession().createQuery("from User where email=?").setParameter(0, email)
				.list();

		if (user.size() > 0) {
			return user.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public VMDetails[] getVMDetails(String email){
		
		List<VMDetails> user = new ArrayList<VMDetails>();
		VMDetails[] vms = new VMDetails[5];

		user = sessionFactory.getCurrentSession().createQuery("from VMDetails where email=?").setParameter(0, email)
				.list();

		if (user.size() > 0) {
			for(int i = 0; i < user.size(); i++){
				vms[i] = user.get(i);
			}
			return vms;
		} else {
			return null;
		}
	}
	
	@Override
	public VMDetails getVMDetails(String email, String vmname){
		
		List<VMDetails> user = new ArrayList<VMDetails>();

		user = ((Query) sessionFactory.getCurrentSession().createQuery("from VMDetails where email=? AND vmname=?").setParameter(0, email).list()) .setParameter(1, vmname).list();

		if (user.size() > 0) {
			return user.get(0);
		} else {
			return null;
		}
	}
}
