package com.myereputation.common;

import java.util.ArrayList;
import java.util.List;

import com.myereputation.bean.RegionBean;
import com.myereputation.persistence.model.Region;

public class Utility {
	public static Region createModelRegion(RegionBean regionBean) {
		Region region = new Region();
		region.setName(region.getName());
		return region;
	}

	public static List<RegionBean> createRegionBeanList(List<Region> regions) {
		List<RegionBean> beans = new ArrayList<RegionBean>();
		RegionBean regionBean = null;
		for (Region region : regions) {
			regionBean = new RegionBean();
			regionBean.setName(region.getName());
			beans.add(regionBean);
		}
		return beans;

	}
}
