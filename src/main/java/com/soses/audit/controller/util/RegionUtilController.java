package com.soses.audit.controller.util;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.soses.audit.cache.province.ProvinceCacheService;
import com.soses.audit.entity.Province;

@Controller
@RequestMapping("/util")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class RegionUtilController {

	private ProvinceCacheService provinceCache;
	
	public RegionUtilController(ProvinceCacheService provinceCache) {
		super();
		this.provinceCache = provinceCache;
	}


	@GetMapping(value="/region/{regionId}", produces="application/json")
	public @ResponseBody List<Province> test(@PathVariable String regionId) {
		
		List<Province> provinceList = provinceCache.getProvinceListByRegion(regionId);
		
		return provinceList;
	}
}
