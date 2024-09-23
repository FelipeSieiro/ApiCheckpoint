package com.tripair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class TripairApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripairApplication.class, args);
	}

}
