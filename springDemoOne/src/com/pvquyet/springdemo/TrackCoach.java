package com.pvquyet.springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	
	public TrackCoach() {
	}

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 50km";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFotuneService();
	}
	
	public void doMyStartupStuff() {
		System.out.println("Bean created.");
	}
	
	public void doMyCleanupStuffYoYo() {
		System.out.println("Bean had been destroyed.");
	}
}
