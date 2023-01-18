package com.pvquyet.spring.annotaion;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String name;
	
	@Value("${foo.email}")
	private String email;
	
	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}

	// define a setter method
	@Autowired
	@Qualifier("randomFortuneService")
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService()");
		this.fortuneService = theFortuneService;
	}
	
	@PostConstruct
	public void doMyCreateBean() {
		System.out.println("Bean had been created!");
	}
	
	@PreDestroy
	public void doMydestroyBean() {
		System.out.println("Bean had been destroyed!");
	}
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
	

}
