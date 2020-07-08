package com.ssdgroupc.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssdgroupc.app.entity.Bike;

/**
 * Date: May 26-2020 interface for BikeRepository.
 * 
 * @author aman
 * @version 1.0
 * @category repositories
 *
 */
public interface BikeRepository extends CrudRepository<Bike, Integer> {

}
