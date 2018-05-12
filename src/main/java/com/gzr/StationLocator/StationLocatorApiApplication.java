package com.gzr.StationLocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StationLocatorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StationLocatorApiApplication.class, args);
	}
}
