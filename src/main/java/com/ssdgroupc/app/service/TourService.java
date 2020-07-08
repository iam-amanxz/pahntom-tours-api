package com.ssdgroupc.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdgroupc.app.entity.Tour;
import com.ssdgroupc.app.repository.TourRepository;

/**
 * Date: May 26-2020 Service class for Tour.
 * 
 * @author aman
 * @version 1.0
 * @category Service
 */
@Service
public class TourService {

	/**
	 * Injects TourRepository
	 */
	@Autowired
	private TourRepository tourRepository;

	/**
	 * Method to save a Tour to data source.
	 * 
	 * @param takes in a tour object
	 * @return returns a Tour
	 */
	public Tour addTour(Tour tour) {
		return tourRepository.save(tour);
	}

	/**
	 * Method to get all Tours from data source.
	 * 
	 * @return returns a List of Tours
	 */
	public List<Tour> getAllTours() {
		List<Tour> tours = new ArrayList<>();
		tourRepository.findAll().forEach(tours::add);
		return tours;
	}

	/**
	 * Method to get a Tour from data source.
	 * 
	 * @param takes an int id
	 * @return returns a Tour
	 */
	public Optional<Tour> getTour(int id) {
		return tourRepository.findById(id);
	}

	/**
	 * Method to update a Tour in data source.
	 * 
	 * @param takes an int id
	 * @param takes in a tour object
	 * @return returns the updated Tour
	 */
	public Tour updateTour(int id, Tour tour) {
		return tourRepository.save(tour);
	}

	/**
	 * Method to delete a Tour from data source
	 * 
	 * @param takes an int id
	 */
	public void deleteTour(int id) {
		tourRepository.deleteById(id);
	}

}
