package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WelcomeController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	 
		return new ModelAndView("welcome1");
	}

}
