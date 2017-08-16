package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
@Primary
public class userrolesRepositoryIML implements userrolesRepository{

	@Autowired 
	SessionFactory sessionf;
	public userrolesRepositoryIML(SessionFactory sessionf) {
		super();
		this.sessionf = sessionf;
		
	}

	private Session session;
	


	private Session currentSession() {
		return sessionf.getCurrentSession();
		}

	@Override
	public void saveroles(userRoles roles) {
		session=currentSession();
		session.beginTransaction();
		session.save(roles);
		session.getTransaction().commit();
	
		
	}

}
