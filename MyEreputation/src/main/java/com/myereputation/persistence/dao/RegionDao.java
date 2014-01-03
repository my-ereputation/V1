package com.myereputation.persistence.dao;

import java.util.List;

import com.myereputation.persistence.model.Region;

public interface RegionDao {
	public Region getRegionById(Integer regionID);
	public Region insertRegion(Region region);
	public void updateRegion(Region region);
	public List<Region> getAllRegions();
	public void deleteRegion(Region region);
}
