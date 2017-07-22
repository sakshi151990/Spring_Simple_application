package spitter.data;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Primary
@Transactional
public class HibernateSpitterRepository implements spitterRepository{

	@Autowired
private 	SessionFactory Sessionfactory; 
	
private Session session;
public HibernateSpitterRepository(SessionFactory sessionFactory) {
this.Sessionfactory = sessionFactory;
}


private Session currentSession() {
return Sessionfactory.getCurrentSession();
}

	@Override
	public void save(Spitter unsaved) {
		
		session=currentSession();
		System.out.println(Sessionfactory);
		System.out.println(session);
		unsaved.setId(1234L);
this.session.beginTransaction();
		session.save(unsaved)	;
		session.getTransaction().commit();
		
		
	}

	@Override
	public Spitter findByUsername(String username) {
		
		return (Spitter) currentSession().createCriteria(Spitter.class).add(Restrictions.eq("username",username)).list().get(0);
	}

}
