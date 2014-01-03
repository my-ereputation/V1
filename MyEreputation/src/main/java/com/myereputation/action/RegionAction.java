package com.myereputation.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.myereputation.bean.RegionBean;
import com.myereputation.common.Utility;
import com.myereputation.persistence.model.Region;
import com.myereputation.service.RegionService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegionAction extends ActionSupport implements ModelDriven<RegionBean> {
private static final long serialVersionUID = 1L;
	
	@Autowired
	private RegionBean regionBean;
	@Autowired
	private RegionService regionService;
	private List<RegionBean> regions;
	private static Logger logger = Logger.getLogger(RegionAction.class);

	
	public RegionBean getModel() {
		return regionBean;
	}
	
	public String view()	{
		List<Region> regionsDao = regionService.getAllRegions();
		logger.debug("Size liste : " + regionsDao.size());
		regions = Utility.createRegionBeanList(regionsDao);
		return SUCCESS;
	}
	
	public String addRegion(){
		regionService.insertRegion(Utility.createModelRegion(regionBean));
		regions = Utility.createRegionBeanList(regionService.getAllRegions());
		return "addRegion";
	}

	public List<RegionBean> getRegions() {
		return regions;
	}

	public void setRegions(List<RegionBean> regions) {
		this.regions = regions;
	}
	
}
