package com.bitMiners.pdf.repository.repositoryImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bitMiners.pdf.domain.QuestionType;
import com.bitMiners.pdf.repository.QuestionTypeRepository;
@Repository
@Transactional
public class QuestionTypeRepositoryImpl implements QuestionTypeRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer add(QuestionType questionType) {
		return (Integer) sessionFactory.getCurrentSession().save(questionType);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public boolean update(QuestionType t) {
		// TODO Auto-generated method stub
		return false;
	}

	public QuestionType findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<QuestionType> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from QuestionType").list();
	}

	
}
