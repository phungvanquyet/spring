package com.pvquyet.spring.annotaion;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "this is database fortuneService";
	}

}
