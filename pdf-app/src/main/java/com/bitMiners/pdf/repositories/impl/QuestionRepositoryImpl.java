package com.bitMiners.pdf.repositories.impl;

import com.bitMiners.pdf.domain.Question;
import com.bitMiners.pdf.exceptions.PdfApiException;
import com.bitMiners.pdf.repositories.QuestionRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
        int result = query.executeUpdate();
        if (result < 1) {
            throw new PdfApiException("Error while deleting question with id: " + id, 500);
        }
    }

    public Question update(Question question) {
        Query query = sessionFactory.getCurrentSession().createQuery("update Question q set q.questionContent=:content where q.id=:id");
        query.setParameter("content", question.getQuestionContent());
        query.setParameter("id", question.getId());
        int result = query.executeUpdate();
        if (result < 1) {
            throw new PdfApiException("Error while updating question with id: " + question.getId(), 500);
        }
        return question;
    }

    public Question findOne(Integer id) {
        return sessionFactory.getCurrentSession().get(Question.class, id);
    }

    public List<Question> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Question", Question.class).list();
    }
}
