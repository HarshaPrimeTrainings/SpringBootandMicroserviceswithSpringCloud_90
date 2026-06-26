package com.training.springhibernatedemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public String saveUser(User u) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.persist(u);
		tr.commit();
		session.close();
		return "User Created";
	}
	
	public User getUserById(Integer uid) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		User usr = session.find(User.class, uid); // load object from the cache
		//User usr = session.get(User.class, uid); // hit the DB
		tr.commit();
		session.close();
		return usr;
	}
	
	public String deleteUser(Integer uid) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		User usr = session.find(User.class, uid);
		session.remove(usr);
		tr.commit();
		session.close();
		return "User Deleted";
	}
	
	public List<User> getAllUsers(){
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		List<User> users = session.createQuery("from User",User.class).getResultList();
		 session.close();
		 return users;
	}
	
	public User updateUser(Integer uid, User usr) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		User existingusr = session.find(User.class, uid);
		existingusr.setName(usr.getName()!=null?usr.getName():existingusr.getName());
		existingusr.setAddr(usr.getAddr()!=null?usr.getAddr():existingusr.getAddr());
		existingusr.setContact(usr.getContact()!=null?usr.getContact():existingusr.getContact());
		tr.commit();
		session.close();
		return existingusr;
	}
	
	
	
}
