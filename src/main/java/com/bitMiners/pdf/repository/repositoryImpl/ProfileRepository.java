package com.bitMiners.pdf.repository.repositoryImpl;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bitMiners.pdf.domain.Profile;
import com.bitMiners.pdf.baseRepository.CrudRepository;
@Repository
//@Transactional
public class ProfileRepository implements CrudRepository<Profile, Integer> {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Integer add(Profile profile) {
		int ret = (Integer)sessionFactory.getCurrentSession().save(profile);
		return ret;
	}

	public void delete(Integer id) {
		
	}

	public boolean update(Profile profile) {
		System.out.println("----------------ProfileRepository:update: " + profile.toString());
		sessionFactory.getCurrentSession().merge(profile);
		sessionFactory.getCurrentSession().flush();
		return true;
	}

	public Profile findOne(Integer id) {
		Profile profile = (Profile)sessionFactory.getCurrentSession().load(Profile.class, id);
		return profile;
	}

	public List<Profile> findAll() {
		return null;
	}

}
