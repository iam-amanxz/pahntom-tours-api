package com.ssdgroupc.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssdgroupc.app.entity.Tour;

/**
 * Date: May 26-2020 interface for TourRepository.
 * 
 * @author aman
 * @version 1.0
 * @category repositories
 *
 */
public interface TourRepository extends CrudRepository<Tour, Integer> {

}
