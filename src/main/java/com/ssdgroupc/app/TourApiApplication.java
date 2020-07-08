package com.ssdgroupc.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Date: May 26-2020 Main Class.
 * 
 * @author aman
 * @version 1.0
 * @category main
 */
@SpringBootApplication
public class TourApiApplication {

	private static final Logger LOGGER = LogManager.getLogger(TourApiApplication.class);

	/**
	 * Main method of the application.
	 * 
	 * @param takes an array of args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TourApiApplication.class, args);
		LOGGER.info("Application Started");

	}

}