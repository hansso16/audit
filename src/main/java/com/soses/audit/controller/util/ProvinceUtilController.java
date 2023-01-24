package com.soses.audit.controller.util;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.soses.audit.cache.municipal.MunicipalCacheService;
import com.soses.audit.entity.Municipal;

@Controller
@RequestMapping("/util")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class ProvinceUtilController {

	private MunicipalCacheService municipalCache;
	
	public ProvinceUtilController(MunicipalCacheService municipalCache) {
		super();
		this.municipalCache = municipalCache;
	}


	@GetMapping(value="/province/{provinceId}", produces="application/json")
	public @ResponseBody List<Municipal> test(@PathVariable String provinceId) {
		
		List<Municipal> municipalList = municipalCache.getMunicipalListByProvince(provinceId);
		
		return municipalList;
	}
}
