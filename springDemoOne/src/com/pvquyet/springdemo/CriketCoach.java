package com.pvquyet.springdemo;

public class CriketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String emailAddress;
	
	private String team;
	
	public CriketCoach() {
		System.out.println("CriketCoach: inside no-arg constructor");
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("inside setter method - fortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run 100m today!!!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFotuneService();
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("inside setter method - emailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("inside setter method - team");
		this.team = team;
	}
	

}
