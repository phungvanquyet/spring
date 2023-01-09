package com.pvquyet.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// load spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from container
		CriketCoach coach = context.getBean("myCricketCoach", CriketCoach.class);
				
		// call methods on the bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getEmailAddress());
		System.out.println(coach.getTeam());
		
		// close context
		context.close();

	}

}
