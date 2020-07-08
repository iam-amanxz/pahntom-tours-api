package com.ssdgroupc.app.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssdgroupc.app.entity.Reservation;
import com.ssdgroupc.app.entity.Rideout;
import com.ssdgroupc.app.entity.Tour;
import com.ssdgroupc.app.repository.ReservationRepository;
import com.ssdgroupc.app.service.ReservationService;

@SpringBootTest
class ReservationControllerTest {

	@Mock
	ReservationRepository repository;

	@InjectMocks
	ReservationService service;

	@Test
	void testGetAllReservations() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Reservation(1, "Tour", "Aman", "aman@gmail.com", "0767971071", new Tour(1)),
						new Reservation(2, "Ridout", "Max", "max@gmail.com", "0767971071", new Rideout(2)))
				.collect(Collectors.toList()));

		assertEquals(2, service.getAllReservations().size());
	}

	@Test
	void testGetReservation() {
		Reservation r = new Reservation(2, "Ridout", "Max", "max@gmail.com", "0767971071", new Rideout(2));
		int id = 2;
		when(repository.findById(id)).thenReturn(Optional.of(r));
		verify(repository, times(0)).findById(r.getReservationId());
	}

	@Test
	void testAddReservationForTour() {
		Reservation r = new Reservation(2, "Tour", "Max", "max@gmail.com", "0767971071", new Tour(2));
		when(repository.save(r)).thenReturn(r);
		assertEquals(r, service.addReservation(r));
	}

	@Test
	void testAddReservationForRideout() {
		Reservation r = new Reservation(2, "Rideout", "Max", "max@gmail.com", "0767971071", new Rideout(2));
		when(repository.save(r)).thenReturn(r);
		assertEquals(r, service.addReservation(r));
	}

	@Test
	void testDeleteReservation() {
		Reservation r = new Reservation(2, "Rideout", "Max", "max@gmail.com", "0767971071", new Rideout(2));
		service.deleteReservation(r.getReservationId());
		verify(repository, times(1)).deleteById(r.getReservationId());
	}

}
