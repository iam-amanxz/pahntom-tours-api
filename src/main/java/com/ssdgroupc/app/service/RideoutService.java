package com.ssdgroupc.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdgroupc.app.entity.Rideout;
import com.ssdgroupc.app.repository.RideoutRepository;

/**
 * Date: May 26-2020 Service class for Rideout.
 * 
 * @author aman
 * @version 1.0
 * @category Service
 */
@Service
public class RideoutService {

	/**
	 * Injects RideoutRepository
	 */
	@Autowired
	private RideoutRepository rideoutRepository;

	/**
	 * Method to save a Rideout to data source.
	 * 
	 * @param takes in a rideout object
	 * @return returns a Rideout
	 */
	public Rideout addRideout(Rideout rideout) {
		return rideoutRepository.save(rideout);
	}

	/**
	 * Method to get all Rideouts from data source.
	 * 
	 * @return returns a List of Rideouts
	 */
	public List<Rideout> getAllRideouts() {
		List<Rideout> rideouts = new ArrayList<>();
		rideoutRepository.findAll().forEach(rideouts::add);
		;
		return rideouts;
	}

	/**
	 * Method to get a Rideout from data source.
	 * 
	 * @param takes an int id
	 * @return returns a Rideout
	 */
	public Optional<Rideout> getRideout(int id) {
		return rideoutRepository.findById(id);
	}

	/**
	 * Method to update a Rideout in data source.
	 * 
	 * @param takes an int id
	 * @param takes in a rideout object
	 * @return returns the updated Rideout
	 */
	public Rideout updateRideout(int id, Rideout rideout) {
		return rideoutRepository.save(rideout);
	}

	/**
	 * Method to delete a Rideout from data source
	 * 
	 * @param takes an int id
	 */
	public void deleteRideout(int id) {
		rideoutRepository.deleteById(id);
	}

}
