package com.bitMiners.pdf.repository.repositoryImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitMiners.pdf.domain.Answer;
import com.bitMiners.pdf.repository.CrudRepository;

@Repository
public class AnswerRepository implements CrudRepository<Answer, Integer> {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Integer add(Answer answer) {
		return (Integer) sessionFactory.getCurrentSession().save(answer);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public boolean update(Answer t) {
		// TODO Auto-generated method stub
		return false;
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
