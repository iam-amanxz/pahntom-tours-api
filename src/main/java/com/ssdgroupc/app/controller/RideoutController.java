package com.ssdgroupc.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.ssdgroupc.app.entity.Rideout;
import com.ssdgroupc.app.service.RideoutService;

import javassist.NotFoundException;

/**
 * Date: May 26-2020 REST controller class for Rideout.
 * 
 * @author aman
 * @version 1.0
 * @category Controller
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RideoutController {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Injects RideoutService class.
	 */
	@Autowired
	private RideoutService rideoutService;

	/**
	 * Method to get all Rideouts.
	 * 
	 * @return returns List of rideouts and HttpStatus:OK
	 * @throws NotFoundException
	 */
	@GetMapping(value = "/rideouts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Rideout>> getAllRideouts() throws NotFoundException {

		List<Rideout> rideouts = rideoutService.getAllRideouts();
		if (rideouts.isEmpty()) {
			LOGGER.info("Rideout records are empty");
			throw new NotFoundException("No rideout records were found");
		}

		return new ResponseEntity<List<Rideout>>(rideouts, HttpStatus.OK);
	}

	/**
	 * Method to get a Rideout.
	 * 
	 * @param takes an int id
	 * @return returns a Reservation and HttpStatus:OK
	 * @throws NotFoundException
	 */
	@GetMapping(value = "/rideouts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rideout> getTour(@PathVariable(value = "id") int id) throws NotFoundException {

		Optional<Rideout> rideout = rideoutService.getRideout(id);

		if (!rideout.isPresent()) {
			LOGGER.info("Rideout record not found");
			throw new NotFoundException("No Rideout record were found");
		}

		return new ResponseEntity<Rideout>(rideout.get(), HttpStatus.OK);
	}

	/**
	 * Method to add a Rideout.
	 * 
	 * @param takes a rideout object
	 * @return returns added Rideout and HttpStatus:CREATED
	 */
	@PostMapping(value = "/rideouts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rideout> addRideout(@Valid @RequestBody Rideout rideout) {

		Optional<Rideout> r = rideoutService.getRideout(rideout.getRideoutId());
		if (r.isPresent()) {

			LOGGER.error("Item already exists");
			throw new HttpClientErrorException(HttpStatus.CONFLICT,
					"Rideout with ID" + "(" + rideout.getRideoutId() + ") already exists");
		}

		return new ResponseEntity<Rideout>(rideoutService.addRideout(rideout), HttpStatus.CREATED);
	}

	/**
	 * Method to update a Rideout.
	 * 
	 * @param takes an int id
	 * @param takes a rideout object
	 * @return returns updated Rideout and HttpStatus:ACCEPTED
	 */
	@PutMapping(value = "/rideouts/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rideout> updateRideout(@PathVariable(value = "id") int id, @RequestBody Rideout rideout) {

		return new ResponseEntity<Rideout>(rideoutService.updateRideout(id, rideout), HttpStatus.ACCEPTED);
	}

	/**
	 * Method to delete a Rideout.
	 * 
	 * @param takes an int id
	 * @return HttpStatus:NO_CONTENT
	 */
	@DeleteMapping("/rideouts/{id}")
	public ResponseEntity<Object> deleteRideout(@PathVariable(value = "id") int id) {

		rideoutService.deleteRideout(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

//	@GetMapping(value = "/rideouts", produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<Rideout> getAllTours() {
//		return rideoutService.getAllRideouts();
//	}
//
//	@GetMapping(value = "/rideouts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Optional<Rideout> getTour(@PathVariable(value = "id") int id) {
//		return rideoutService.getRideout(id);
//	}
//
//	@PostMapping(value = "/rideouts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public void addRideout(@Valid @RequestBody Rideout rideout) {
//		rideoutService.addRideout(rideout);
//	}
//
//	@PutMapping(value = "/rideouts/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public void updateRideout(@PathVariable(value = "id") int id, @RequestBody Rideout rideout) {
//		rideoutService.updateRideout(id, rideout);
//	}
//
//	@DeleteMapping("/rideouts/{id}")
//	public void deleteRideout(@PathVariable(value = "id") int id) {
//		rideoutService.deleteRideout(id);
//	}

}
