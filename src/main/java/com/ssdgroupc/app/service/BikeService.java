package com.ssdgroupc.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdgroupc.app.entity.Bike;
import com.ssdgroupc.app.repository.BikeRepository;

/**
 * Date: May 26-2020 Service class for Bike.
 * 
 * @author aman
 * @version 1.0
 * @category Service
 */
@Service
public class BikeService {

	/**
	 * Injects BikeRepository
	 */
	@Autowired
	private BikeRepository bikeRepository;

	/**
	 * Method to save a Bike to data source
	 * 
	 * @param takes in a bike object
	 * @return returns a Bike
	 */
	public Bike addBike(Bike bike) {
		return bikeRepository.save(bike);
	}

	/**
	 * Method to get all bikes from data source
	 * 
	 * @return returns a List of Bikes
	 */
	public List<Bike> getAllBikes() {
		List<Bike> bikes = new ArrayList<>();
		bikeRepository.findAll().forEach(bikes::add);
		return bikes;
	}

	/**
	 * Method to update a Bike in data source
	 * 
	 * @param takes an int id
	 * @param takes a bike object
	 * @return returns the updated Bike
	 */
	public Bike updateBike(int id, Bike bike) {
		return bikeRepository.save(bike);
	}

	/**
	 * Method to delete a Bike from data source
	 * 
	 * @param takes an int id
	 */
	public void deleteBike(int id) {
		bikeRepository.deleteById(id);
	}

}
