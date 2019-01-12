package com.bitMiners.pdf.repositories.impl;

import com.bitMiners.pdf.domain.Profile;
import com.bitMiners.pdf.repositories.ProfileRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProfileRepositoryImpl implements ProfileRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Integer add(Profile profile) {
        return (Integer) sessionFactory.getCurrentSession().save(profile);
    }

    public void delete(Integer id) {

    }

    public boolean update(Profile profile) {
        sessionFactory.getCurrentSession().merge(profile);
        sessionFactory.getCurrentSession().flush();
        return true;
    }

    public Profile findOne(Integer id) {
        return sessionFactory.getCurrentSession().load(Profile.class, id);
    }

    public List<Profile> findAll() {
        return null;
    }
}
