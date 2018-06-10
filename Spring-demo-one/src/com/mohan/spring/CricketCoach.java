package com.mohan.spring;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public CricketCoach() {
		System.out.println("CricketCoach: class started");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Set fortune Service called");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice defence and spin bowling";
	}

	@Override
	public String getDailyFortune() {
		return "Beat the blue";
	}

	
	
	

}
