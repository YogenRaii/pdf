package com.bitMiners.pdf.repositories.impl;

import com.bitMiners.pdf.domain.QuestionType;
import com.bitMiners.pdf.repositories.QuestionTypeRepository;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class QuestionTypeRepositoryImpl implements QuestionTypeRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Integer add(QuestionType questionType) {
        return (Integer) sessionFactory.getCurrentSession().save(questionType);
    }

    public void delete(Integer id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from QuestionType q where q.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean update(QuestionType questionType) {
        Query query = sessionFactory.getCurrentSession().createQuery("update QuestionType q set q.description=:content where q.id=:id");
        query.setParameter("content", questionType.getDescription());
        query.setParameter("id", questionType.getId());
        query.executeUpdate();
        return true;
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
