package com.ssdgroupc.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ssdgroupc.app.entity.Bike;
import com.ssdgroupc.app.service.BikeService;

import javassist.NotFoundException;

/**
 * Date: May 26-2020 REST controller class for Bike.
 * 
 * @author aman
 * @version 1.0
 * @category Controller
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class BikeController {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Injects BikeService class
	 */
	@Autowired
	private BikeService bikeService;

	/**
	 * Method to get all bikes.
	 * 
	 * @return returns List of bikes and HttpStatus:OK
	 * @throws NotFoundException
	 */
	@GetMapping(value = "/bikes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Bike>> getAllBikes() throws NotFoundException {

		List<Bike> bikes = bikeService.getAllBikes();

		if (bikes.isEmpty()) {
			LOGGER.info("Bike records are empty");
			throw new NotFoundException("No bike records were found");
		}

		return new ResponseEntity<List<Bike>>(bikes, HttpStatus.OK);
	}

	/**
	 * Method to add a Bike.
	 * 
	 * @param takes a bike object
	 * @return returns added Bike and HttpStatus:CREATED
	 */
	@PostMapping(value = "/bikes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bike> addBike(@Valid @RequestBody Bike bike) {

		return new ResponseEntity<Bike>(bikeService.addBike(bike), HttpStatus.CREATED);
	}

	/**
	 * Method to delete a Bike.
	 * 
	 * @param takes an int id
	 * @return returns HttpStatus:NO_CONTENT
	 */
	@DeleteMapping("/bikes/{id}")
	public ResponseEntity<Object> deleteBike(@PathVariable(value = "id") int id) {

		bikeService.deleteBike(id);

		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

//	Before Response

//	@GetMapping("/bikes")
//	public List<Bike> getAllBikes() {
//		LOGGER.error("Hitttt");
//		return bikeService.getAllBikes();
//	}
//	
//	@DeleteMapping("/bikes/{id}")
//	public void deleteBike(@PathVariable(value = "id") int id) {
//		bikeService.deleteBike(id);
//	}
//	
//	@PostMapping(value = "/bikes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public void addBike(@Valid @RequestBody Bike bike) {
//
//		bikeService.addBike(bike);
//	}

}
