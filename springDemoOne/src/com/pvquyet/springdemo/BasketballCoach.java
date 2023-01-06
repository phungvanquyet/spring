package com.pvquyet.springdemo;

public class BasketballCoach implements Coach {

	private  FortuneService fortuneService;
	
	public BasketballCoach() {
		
	}

	public BasketballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run 30 minites on the road";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFotuneService();
	}

}
