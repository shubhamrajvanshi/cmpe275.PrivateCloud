package edu.sjsu.cmpe275.VmDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.cmpe275.VmModel.User;
import edu.sjsu.cmpe275.VmModel.VMDetails;

//import edu.sjsu.cmpe275.VmModel.*;

@SuppressWarnings("unused")
@Repository
@Transactional
@EnableTransactionManagement
public class VMDaoImpl implements VmDao{

	//@Autowired 
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	
	@Override 
//	@Transactional
	public User getUser(String email){
		
//		List<User> user = new ArrayList<User>();
//
//		user = this.sessionFactory.getCurrentSession().createQuery("from User where email=?").setParameter(0, email)
//				.list();
//
//		if (user.size() > 0) {
//			return user.get(0);
//		} else {
//			return null;
//		}
	//	System.out.println(sessionFactory.getCurrentSession().isConnected());
		 return  (User) this.sessionFactory.getCurrentSession().load(User.class, new String(email));
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public VMDetails[] getVMDetails(String email){
		
		List<VMDetails> user = new ArrayList<VMDetails>();
		VMDetails[] vms = new VMDetails[5];

		user = this.sessionFactory.getCurrentSession().createQuery("from VMDetails where email=?").setParameter(0, email)
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
	
	@SuppressWarnings("unchecked")
	@Override
	public VMDetails getVMDetails(String email, String vmname){
		
		List<VMDetails> user = new ArrayList<VMDetails>();

		user = ((Query) this.sessionFactory.getCurrentSession().createQuery("from VMDetails where email=? AND vmname=?").setParameter(0, email).list()) .setParameter(1, vmname).list();

		if (user.size() > 0) {
			return user.get(0);
		} else {
			return null;
		}
	}
}
