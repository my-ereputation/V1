package com.myereputation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myereputation.persistence.dao.RegionDao;
import com.myereputation.persistence.model.Region;
import com.myereputation.service.RegionService;

@Service("regionService")
@Transactional
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionDao regionDao;

	public Region getRegionById(Integer regionID) {
		return regionDao.getRegionById(regionID);
	}

	public Region insertRegion(Region region) {
		return regionDao.insertRegion(region);
	}

	public void updateRegion(Region region) {
		regionDao.updateRegion(region);

	}

	public List<Region> getAllRegions() {
		return regionDao.getAllRegions();
	}

	public void deleteRegion(Region region) {
		regionDao.deleteRegion(region);
	}

}
