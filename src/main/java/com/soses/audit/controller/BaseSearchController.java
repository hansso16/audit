package com.soses.audit.controller;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

public abstract class BaseSearchController {

	protected <T> void setPaginationVariables(Page<T> page, Model model) { //add parameter pageName for flexibility
		model.addAttribute("currentPage", page.getNumber());
		model.addAttribute("page", page);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalRows", page.getTotalElements());
	}
}
