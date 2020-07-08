package com.ssdgroupc.app.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssdgroupc.app.entity.Tour;
import com.ssdgroupc.app.repository.TourRepository;
import com.ssdgroupc.app.service.TourService;

@SpringBootTest
class TourControllerTest {

	@Mock
	TourRepository repository;

	@InjectMocks
	TourService service;

	@Test
	void testGetAllTours() {
		List<Tour> toursList = new ArrayList<>();
		Tour t1 = new Tour(1, "Garden 62", "Join us", "https://rideoutafrica.com", 2, 125.0, 656.0, 12, "costal",
				"Colombo", "Matara", true, "https://rideoutafrica.com");
		Tour t2 = new Tour(2, "Garden 62", "Join us", "https://rideoutafrica.com", 2, 125.0, 656.0, 12, "costal",
				"Colombo", "Matara", true, "https://rideoutafrica.com");

		toursList.add(t1);
		toursList.add(t2);

		when(repository.findAll()).thenReturn(toursList);
		assertEquals(2, service.getAllTours().size());
	}

	@Test
	void testGetTour() {
		Tour t = new Tour(1, "Garden 62", "Join us", "https://rideoutafrica.com", 2, 125.0, 656.0, 12, "costal",
				"Colombo", "Matara", true, "https://rideoutafrica.com");
		int id = 1;
		when(repository.findById(id)).thenReturn(Optional.of(t));
		verify(repository, times(0)).findById(t.getTourId());
	}

	@Test
	void testAddTour() {
		Tour t = new Tour(1, "Garden 62", "Join us", "https://rideoutafrica.com", 2, 125.0, 656.0, 12, "costal",
				"Colombo", "Matara", true, "https://rideoutafrica.com");

		when(repository.save(t)).thenReturn(t);
		assertEquals(t, service.addTour(t));
	}

	@Test
	void testDeleteTour() {
		Tour t = new Tour(1, "Garden 62", "Join us", "https://rideoutafrica.com", 2, 125.0, 656.0, 12, "costal",
				"Colombo", "Matara", true, "https://rideoutafrica.com");

		service.deleteTour(t.getTourId());
		verify(repository, times(1)).deleteById(t.getTourId());
	}

}
