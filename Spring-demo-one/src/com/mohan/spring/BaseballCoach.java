package com.mohan.spring;

public class BaseballCoach implements Coach{
	
	//define a private field for the dependency
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
		
	}
	
	@Override
	public String getDailyWorkout(){
		return "Spend 30 minutes on batting";
	}

	@Override
	public String getDailyFortune() {
		
		//Use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}

}
