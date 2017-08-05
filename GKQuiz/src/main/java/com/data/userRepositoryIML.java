package com.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
@Primary
public class userRepositoryIML implements userRepository {

	@Autowired 
	SessionFactory sessionf;
	public userRepositoryIML(SessionFactory sessionf) {
		super();
		this.sessionf = sessionf;
		
	}

	private Session session;
	


	private Session currentSession() {
		return sessionf.getCurrentSession();
		}


	@Override
	public void saveUser(User user) {
		
		
		session=currentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	
	}


	@Override
	public User finduser(int userid) {
		session=currentSession();
		User user=(User) session.createCriteria(User.class).add(Restrictions.eq("userid",userid)).list().get(0);
		System.out.println(user.getUserid());
		return user ;	}





	

}
