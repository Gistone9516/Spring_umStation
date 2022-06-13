package com.spring.test.controller;

import java.util.Date;
import java.util.Random;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.spring.test.domain.rental_logVO;
import com.spring.test.domain.rental_umVO;
import com.spring.test.domain.stationVO;
import com.spring.test.domain.userVO;
import com.spring.test.persistence.rentalDAO;
import com.spring.test.persistence.stationDAO;
import com.spring.test.persistence.userDAO;

public class ControllerAssistance {
	private static final Logger logger = 
			LoggerFactory.getLogger(ControllerAssistance.class);
	
	private userDAO userdao;
	private rentalDAO rendao;
	private stationDAO statdao; 
	
	public ControllerAssistance(userDAO user, rentalDAO rental, stationDAO station){
		this.userdao = user;
		this.rendao = rental;
		this.statdao = station;
	}

	
}