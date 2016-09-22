package com.ecommerce.quickart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ecommerce.quickart.model.User;

@Repository
@Transactional
public class UserDaoImp implements UserDao{
	@Autowired
	private SessionFactory sessionFactory ;
	public UserDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveUser(User user) {
		try{
			sessionFactory.getCurrentSession().save(user);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		
		}
		return true;
		
	}

	public boolean updateUser(User user) {
		try{
			sessionFactory.getCurrentSession().update(user);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		
		}
		return true;
		
	}

	public boolean deleteUser(String userId) {
		try{
			sessionFactory.getCurrentSession().delete(getUser(userId));
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		
		}
		return true;
		
	}

	public User getUser(String userId) {
		String hql = "from usercredential where id = '" + userId + "'" ;
		List<User> userList = sessionFactory.getCurrentSession().createQuery(hql).list();
		if(userList == null){
		 return null ;	
		}
		else
		return userList.get(0);
		
	}

	public List<User> UserList() {
		String hql = "from usercredential" ;
		List<User> userList = sessionFactory.getCurrentSession().createQuery(hql).list();
		if(userList == null){
		 return null ;	
		}
		else
		return userList ;
		
	}

}
