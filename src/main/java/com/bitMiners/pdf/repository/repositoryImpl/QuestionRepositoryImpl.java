package com.bitMiners.pdf.repository.repositoryImpl;

import com.bitMiners.pdf.domain.Question;
import com.bitMiners.pdf.repository.QuestionRepository;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class QuestionRepositoryImpl implements QuestionRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Integer add(Question question) {
        return (Integer) sessionFactory.getCurrentSession().save(question);
    }

    public void delete(Integer id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Question q where q.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();

    }

    public boolean update(Question question) {

        Query query = sessionFactory.getCurrentSession().createQuery("update Question q set q.questionContent=:content where q.id=:id");
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
