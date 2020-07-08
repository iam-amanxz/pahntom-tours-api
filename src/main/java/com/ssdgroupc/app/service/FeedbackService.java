package com.ssdgroupc.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdgroupc.app.entity.Feedback;
import com.ssdgroupc.app.repository.FeedbackRepository;

/**
 * Date: May 26-2020 Service class for Feedback.
 * 
 * @author aman
 * @version 1.0
 * @category Service
 */
@Service
public class FeedbackService {

	/**
	 * Injects FeedbackRepository
	 */
	@Autowired
	private FeedbackRepository feedbackRepository;

	/**
	 * Method to save a Feedback to data source
	 * 
	 * @param takes in a feedback object
	 * @return returns a Feedback
	 */
	public Feedback addFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	/**
	 * Method to get all feedbacks from data source
	 * 
	 * @return returns a List of Feedbacks
	 */
	public List<Feedback> getAllFeedbacks() {
		List<Feedback> feedbacks = new ArrayList<>();
		feedbackRepository.findAll().forEach(feedbacks::add);
		return feedbacks;
	}

	/**
	 * Method to delete a Feedback from data source
	 * 
	 * @param takes an int id
	 */
	public void deleteFeedback(int id) {
		feedbackRepository.deleteById(id);
	}

}
