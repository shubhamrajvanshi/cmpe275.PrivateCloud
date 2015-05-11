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

import edu.sjsu.cmpe275.VmModel.Host;
import edu.sjsu.cmpe275.VmModel.User;
import edu.sjsu.cmpe275.VmModel.VMDetails;

//import edu.sjsu.cmpe275.VmModel.*;

@SuppressWarnings("unused")
@Repository
@Transactional
//@EnableTransactionManagement
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
		
		List<User> user = new ArrayList<User>();

		user = this.sessionFactory.getCurrentSession().createQuery("from User where email=?").setParameter(0, email)
				.list();

		if (user.size() > 0) {
			return user.get(0);
		} else {
			return null;
		}
	//	System.out.println(sessionFactory.getCurrentSession().isConnected());
	//	 return  (User) this.sessionFactory.getCurrentSession().load(User.class, new String(email));
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<VMDetails> getVMDetails(String email){
		
		List<VMDetails> user = new ArrayList<VMDetails>();
		user = this.sessionFactory.getCurrentSession().createQuery("from VMDetails where email=?").setParameter(0, email)
				.list();
		VMDetails[] vms = new VMDetails[user.size()];
		if (user.size() > 0) {
			for(int i = 0; i < user.size(); i++){
				vms[i] = user.get(i);
				
				//System.out.println(vms[i].getVmname());
			}
			return user;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public VMDetails getVMDetails(String email, String vmname){
		
		List<VMDetails> vms = new ArrayList<VMDetails>();
		System.out.println("inside hibernet- getVMDetails() get");
		vms = this.sessionFactory.getCurrentSession().createQuery("from VMDetails where vmname=?").setParameter(0, vmname)
				.list();
		
		if (vms.size() > 0) {
			return vms.get(0);
		} else {
			return null;
		}
	}

	@Override
	public boolean setUser(User user) {
		// TODO Auto-generated method stub
		if(this.sessionFactory.getCurrentSession()!=null){
			try{
			this.sessionFactory.getCurrentSession().save(user);
			return true;
			}
			catch (Exception e){
				e.printStackTrace();
				return false;
			}
		}
		else {
			System.out.println("hibernate session not present");
			return false;
		}	
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<VMDetails> getAllVMs(){
		
		List<VMDetails> vms = new ArrayList<VMDetails>();
		System.out.println("inside hibernate get all vms");
		vms = this.sessionFactory.getCurrentSession().createQuery("from VMDetails").list();
		
//		if (vms.size() > 0) {
//			for(int i = 0; i < vms.size(); i++){
//				vms[i] = user.get(i);
//				
//				//System.out.println(vms[i].getVmname());
//			}
			return vms;
		} 
//			else {
//			return null;
//		}
	//}
	
	@Override
	public boolean setVM(VMDetails vm) {
		// TODO Auto-generated method stub
		if(this.sessionFactory.getCurrentSession()!=null){
			try{
			this.sessionFactory.getCurrentSession().save(vm);
			
			return true;
			}
			catch (Exception e){
				e.printStackTrace();
				return false;
			}
		}
		else {
			System.out.println("hibernate session not present");
			return false;
		}	
		
	}
	
	@Override
	public void changeVmState(VMDetails vm) {
		// TODO Auto-generated method stub
		if(this.sessionFactory.getCurrentSession()!=null){
			try{
				
				System.out.println("In changeState DAO");
			this.sessionFactory.getCurrentSession().merge(vm);
			
			//return true;
			}
			catch (Exception e){
				e.printStackTrace();
				//return false;
			}
		}
		else {
			System.out.println("hibernate session not present");
			//return false;
		}	
		
	}
	
	@Override
	public boolean setHost(Host host) {
		
		if(this.sessionFactory.getCurrentSession()!=null){
			try{
			this.sessionFactory.getCurrentSession().save(host);
			return true;
			}
			catch (Exception e){
				e.printStackTrace();
				return false;
			}
		}
		else {
			System.out.println("hibernate session not present");
			return false;
		}	
	}
	
	
}
