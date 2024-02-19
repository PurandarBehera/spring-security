package com.puru.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicSecurityController {

	@GetMapping("/security")
	public String Security() {
		return "Spring-Security Rocks !!!";
	}
	

	@GetMapping("/bye")
	public String Bye() {
		return "Spring-Security Losttt !!!";
	}

}
