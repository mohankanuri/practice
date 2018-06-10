package com.mohan.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloSpringApp {
	public static void main(String[] args) {

		// load the Spring Configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from Spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		

		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();
	}

}
