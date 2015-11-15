package com.bitMiners.pdf.repository.repositoryImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.repository.CrudRepository;
@Repository
//@Transactional
public class UserRepository implements CrudRepository<User, Integer> {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Integer add(User user) {
		/*Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.persist(user);
		tx.commit();*/
		return (Integer) sessionFactory.getCurrentSession().save(user);
//		return user;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public User findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Query query=sessionFactory.getCurrentSession().createQuery("from User");
		return query.list();
	}

}
