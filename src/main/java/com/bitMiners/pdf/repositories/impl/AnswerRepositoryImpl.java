package com.bitMiners.pdf.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitMiners.pdf.domain.Answer;
import com.bitMiners.pdf.repositories.AnswerRepository;

@Repository
public class AnswerRepositoryImpl implements AnswerRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Integer add(Answer answer) {
		return (Integer) sessionFactory.getCurrentSession().save(answer);
	}

	public void delete(Integer id) {
		Query query=sessionFactory.getCurrentSession().createQuery("delete from Answer a where a.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	public boolean update(Answer answer) {
		Query query=sessionFactory.getCurrentSession().createQuery("update Answer a set a.answerContent=:content where a.id=:id");
		query.setParameter("content", answer.getAnswerContent());
		query.setParameter("id", answer.getId());
		query.executeUpdate();
		return true;
	}

	public Answer findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Answer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
