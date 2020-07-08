package com.ssdgroupc.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssdgroupc.app.entity.Feedback;

/**
 * Date: May 26-2020 interface for FeedbackRepository.
 * 
 * @author aman
 * @version 1.0
 * @category repositories
 *
 */
public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {
}
