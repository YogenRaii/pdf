package com.bitMiners.pdf.repository.repositoryImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bitMiners.pdf.domain.Question;
import com.bitMiners.pdf.repository.CrudRepository;
@Repository
//@Transactional
public class QuestionRepository implements CrudRepository<Question, Integer> {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer add(Question question) {
		return (Integer) sessionFactory.getCurrentSession().save(question);
	}

	public void delete(Integer id) {
		Query query=sessionFactory.getCurrentSession().createQuery("delete from Question q where q.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	public boolean update(Question question) {
		System.out.println("------"+question.getQuestionContent());
		
		/*Session session=sessionFactory.getCurrentSession();
		Question oldQues=(Question) session.get(Question.class, question.getId());
		oldQues.setQuestionContent(question.getQuestionContent());
		session.update(oldQues);*/
		
		Query query=sessionFactory.getCurrentSession().createQuery("update Question q set q.questionContent=:content where q.id=:id");
		query.setParameter("content", question.getQuestionContent());
		query.setParameter("id", question.getId());
		query.executeUpdate();
		return true;
	}

	public Question findOne(Integer id) {
		return (Question) sessionFactory.getCurrentSession().get(Question.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Question> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Question").list();
	}
	
	
}
