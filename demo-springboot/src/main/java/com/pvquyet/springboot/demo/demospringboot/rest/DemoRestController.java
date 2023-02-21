package com.pvquyet.springboot.demo.demospringboot.rest;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@Value("${coach.name}")
	private String coachName;

	@Value("${team.name}")
	private String teamName;

	// expose "/" that return hello world
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();
	}

	// expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run hard 35km";
	}

	@GetMapping("/fortune")
	public String getDailyFortunes() {
		return "daily fortune smile";
	}

	@GetMapping("/get-team-info")
	public String getTeamCoachName(){
		return "team= " + this.teamName + "\ncoach= " + this.coachName;
	}

}
