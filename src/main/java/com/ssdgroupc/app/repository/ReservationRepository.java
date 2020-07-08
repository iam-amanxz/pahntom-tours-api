package com.ssdgroupc.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ssdgroupc.app.entity.Reservation;

/**
 * Date: May 26-2020 interface for ReservationRepository.
 * 
 * @author aman
 * @version 1.0
 * @category repositories
 *
 */
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
//	public List<Reservation> findByUserUserId(int userId);
	
	public List<Reservation> findByTourTourId(int tourId);
}
