package com.data;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class questionRepositoryIML implements questionRepository{

	@Autowired
	SessionFactory sessionfactory;
	public questionRepositoryIML(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}

	private Session session;

	private Session currentSession() {
		return sessionfactory.getCurrentSession();
		}
	@SuppressWarnings("unchecked")
	@Override
	public List<Questions> getQuestionAnswer() {
		
		session=currentSession();
		List<Questions> list=session.createCriteria(Questions.class).list();
		
		return list;
	}
	@Override
	public void saveQuestionAnswer(Questions questions) {
		session=currentSession();
		session.beginTransaction();
		session.save(questions);
		session.getTransaction().commit();
		
	}

}
