package com.ssdgroupc.app.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssdgroupc.app.entity.Rideout;
import com.ssdgroupc.app.repository.RideoutRepository;
import com.ssdgroupc.app.service.RideoutService;

@SpringBootTest
class RideoutControllerTest {

	@Mock
	RideoutRepository repository;

	@InjectMocks
	RideoutService service;

	@Test
	void testGetAllTours() {

		List<Rideout> rideoutList = new ArrayList<>();
		Rideout r1 = new Rideout(1, "Garden Route Passes", "Join us for a circular", "https://rideoutafrica.com",
				new Date(), "Colombo", "Matara");
		Rideout r2 = new Rideout(2, "Garden Route Passes", "Join us for a circular", "https://rideoutafrica.com",
				new Date(), "Colombo", "Matara");
		rideoutList.add(r1);
		rideoutList.add(r2);

		when(repository.findAll()).thenReturn(rideoutList);
		assertEquals(2, service.getAllRideouts().size());
	}

	@Test
	void testGetTour() {
		Rideout r1 = new Rideout(1, "Garden Route Passes", "Join us for a circular", "https://rideoutafrica.com",
				new Date(), "Colombo", "Matara");

		int id = 1;
		when(repository.findById(id)).thenReturn(Optional.of(r1));
		verify(repository, times(0)).findById(r1.getRideoutId());
	}

	@Test
	void testAddRideout() {
		Rideout r = new Rideout(1, "Garden Route Passes", "Join us for a circular", "https://rideoutafrica.com",
				new Date(), "Colombo", "Matara");
		when(repository.save(r)).thenReturn(r);
		assertEquals(r, service.addRideout(r));
	}

	@Test
	void testDeleteRideout() {
		Rideout r = new Rideout(1, "Garden Route Passes", "Join us for a circular", "https://rideoutafrica.com",
				new Date(), "Colombo", "Matara");
		service.deleteRideout(r.getRideoutId());
		verify(repository, times(1)).deleteById(r.getRideoutId());
	}

}
