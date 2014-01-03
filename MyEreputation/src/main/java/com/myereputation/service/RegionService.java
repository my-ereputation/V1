package com.myereputation.service;

import java.util.List;

import com.myereputation.persistence.model.Region;

public interface RegionService {
	public Region getRegionById(Integer regionID);
	public Region insertRegion(Region region);
	public void updateRegion(Region region);
	public List<Region> getAllRegions();
	public void deleteRegion(Region region);
}
