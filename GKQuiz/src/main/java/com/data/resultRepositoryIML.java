package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class resultRepositoryIML implements resultRepository{

	@Autowired 
	SessionFactory sessionf;
	public resultRepositoryIML(SessionFactory sessionf) {
		super();
		this.sessionf = sessionf;
		
	}

	private Session session;
	


	private Session currentSession() {
		return sessionf.getCurrentSession();
		}

	
	@Override
	public void saveresult(userresult userresult) {
		
		session=currentSession();
		session.beginTransaction();
		session.save(userresult);
		session.getTransaction().commit();
		
		
		
	}

}
