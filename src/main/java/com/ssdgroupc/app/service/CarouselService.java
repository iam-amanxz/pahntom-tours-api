package com.ssdgroupc.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdgroupc.app.entity.Carousel;
import com.ssdgroupc.app.repository.CarouselRepository;

/**
 * Date: May 26-2020 Service class for Carousel.
 * 
 * @author aman
 * @version 1.0
 * @category Service
 */
@Service
public class CarouselService {

	/**
	 * Injects CarouselRepository
	 */
	@Autowired
	private CarouselRepository carouselRepository;

	/**
	 * Method to get all carousels from data source
	 * 
	 * @return returns a List of Carousels
	 */
	public List<Carousel> getAllCarousels() {
		List<Carousel> carousels = new ArrayList<>();
		carouselRepository.findAll().forEach(carousels::add);
		return carousels;
	}

	/**
	 * Method to save a Carousel to data source
	 * 
	 * @param takes in a carousel object
	 * @return returns a Carousel
	 */
	public Carousel addCarousel(Carousel carousel) {
		return carouselRepository.save(carousel);
	}

	/**
	 * Method to delete a Carousel from data source
	 * 
	 * @param takes an int id
	 */
	public void deleteCarousel(int id) {
		carouselRepository.deleteById(id);
	}

}
