package com.bitMiners.pdf.repositories.impl;

import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.repositories.UserRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
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

    @Override
    public User findOne(Integer id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM User", User.class).list();
    }

    @Override
    public User getUserByUsername(String username) {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("FROM User u where u.username=:username", User.class);
        query.setParameter("username", username);
        return query.uniqueResult();
    }

    @Override
    public List<User> getAllAdmins() {
        NativeQuery<User> query = sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM User u where id in (select user_id FROM user_authority where authority_id=(select id FROM authority where name=:role))");
        query.setParameter("role", "ROLE_ADMIN");
        query.addEntity(User.class);
        return query.list();
    }
}
