package com.bitMiners.pdf.repositories.impl;

import com.bitMiners.pdf.domain.QuestionType;
import com.bitMiners.pdf.exceptions.PdfApiException;
import com.bitMiners.pdf.repositories.QuestionTypeRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class QuestionTypeRepositoryImpl implements QuestionTypeRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Long add(QuestionType questionType) {
        return (Long) sessionFactory.getCurrentSession().save(questionType);
    }

    public void delete(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from QuestionType q where q.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public QuestionType update(QuestionType questionType) {
        Query query = sessionFactory.getCurrentSession().createQuery("update QuestionType q set q.description=:content where q.id=:id");
        query.setParameter("content", questionType.getDescription());
        query.setParameter("id", questionType.getId());
        int result = query.executeUpdate();
        if (result < 1) {
            throw new PdfApiException("Error while updating question type with id: " + questionType.getId(), 500);
        }
        return questionType;
    }

    public QuestionType findOne(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<QuestionType> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from QuestionType", QuestionType.class).list();
    }
}
