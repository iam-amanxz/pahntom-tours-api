package com.ssdgroupc.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdgroupc.app.entity.Reservation;
import com.ssdgroupc.app.repository.ReservationRepository;

/**
 * Date: May 26-2020 Service class for Reservation.
 * 
 * @author aman
 * @version 1.0
 * @category Service
 */
@Service
public class ReservationService {

	/**
	 * Injects ReservationRepository
	 */
	@Autowired
	private ReservationRepository reservationRepository;

	/**
	 * Method to save a Reservation to data source
	 * 
	 * @param takes in a reservation object
	 * @return returns a Reservation
	 */
	public Reservation addReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	/**
	 * Method to get all reservations from data source
	 * 
	 * @return returns a List of Reservations
	 */
	public List<Reservation> getAllReservations() {
		List<Reservation> reservations = new ArrayList<>();
		reservationRepository.findAll().forEach(reservations::add);
		return reservations;
	}

	/**
	 * Method to get a Reservation from data source
	 * 
	 * @param takes an int id
	 * @return returns a Reservation
	 */
	public Optional<Reservation> getReservation(int id) {
		return reservationRepository.findById(id);
	}

	/**
	 * Method to delete a Reservation from data source
	 * 
	 * @param takes an int id
	 */
	public void deleteReservation(int id) {
		reservationRepository.deleteById(id);
	}

//	public List<Reservation> getReservation(int tourId) {
//		return reservationRepository.findByTourTourId(tourId);
//	}

}
