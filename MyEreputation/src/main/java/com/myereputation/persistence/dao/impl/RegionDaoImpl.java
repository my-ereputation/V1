package com.myereputation.persistence.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myereputation.persistence.dao.RegionDao;
import com.myereputation.persistence.model.Region;

@Repository("regionDao")
@Transactional
public class RegionDaoImpl implements RegionDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Region getRegionById(Integer regionID) {
		Region region = (Region) sessionFactory.getCurrentSession().load(Region.class, regionID);
		return region;
	}

	public Region insertRegion(Region region) {
		region = (Region) sessionFactory.getCurrentSession().save(region);
		return region;
	}

	public void updateRegion(Region region) {
		sessionFactory.getCurrentSession().update(region);
	}

	@SuppressWarnings("unchecked")
	public List<Region> getAllRegions() {
		return (List<Region>) sessionFactory.getCurrentSession().createCriteria(Region.class).list();
	}

	public void deleteRegion(Region region) {
		sessionFactory.getCurrentSession().delete(region);
	}

}
