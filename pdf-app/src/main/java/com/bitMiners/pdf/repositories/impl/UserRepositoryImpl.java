package com.bitMiners.pdf.repositories.impl;

import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.repositories.UserRepository;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Integer add(User user) {
        return (Integer) sessionFactory.getCurrentSession().save(user);
    }

    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }

    public boolean update(User user) {
        // TODO Auto-generated method stub
        return false;
    }

    public User findOne(Integer id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.list();
    }

    public User getUserByUsername(String username) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username");
        query.setParameter("username", username);
        return (User) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllAdmins() {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("SELECT * from User u where id in (select user_id from user_authority where authority_id=(select id from authority where name=:role))");
        query.setParameter("role", "ROLE_ADMIN");
        query.addEntity(User.class);
        return query.list();
    }
}
