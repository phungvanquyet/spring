package com.pvquyet.spring.annotaion;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		TennisCoach theCoach = context.getBean("tennisCoach", TennisCoach.class);
		TennisCoach secondCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		boolean theSame = theCoach == secondCoach;
		
		// compare the bean prototype scope
		System.out.println("\ntheCoach and secondCoach is them same object: " + theSame);
		
		// print memory location
		System.out.println("memory location for theCoach " + theCoach);
		System.out.println("memory location for secondCoach " + secondCoach + "\n");
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// get name and email
		System.out.println("\ntheCoach name: " + theCoach.getName());
		System.out.println("theCoach email: " + theCoach.getEmail());
				
		// close the context
		context.close();	
	}

}


