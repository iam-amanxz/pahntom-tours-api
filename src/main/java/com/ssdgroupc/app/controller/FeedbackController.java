package com.ssdgroupc.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssdgroupc.app.entity.Feedback;
import com.ssdgroupc.app.entity.Tour;
import com.ssdgroupc.app.service.FeedbackService;

import javassist.NotFoundException;

/**
 * Date: May 26-2020 REST controller class for Feedback.
 * 
 * @author aman
 * @version 1.0
 * @category Controller
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class FeedbackController {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Injects FeedbackService class
	 */
	@Autowired
	private FeedbackService feedbackService;

	/**
	 * Method to get all Feedbacks.
	 * 
	 * @return returns List of feedbacks and HttpStatus:OK
	 * @throws NotFoundException
	 */
	@GetMapping(value = "/feedbacks", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Feedback>> getAllFeedbacks() throws NotFoundException {

		List<Feedback> feedbacks = feedbackService.getAllFeedbacks();

		if (feedbacks.isEmpty()) {
			LOGGER.info("Feedback records are empty");
			throw new NotFoundException("No feedback records were found");
		}

		return new ResponseEntity<List<Feedback>>(feedbacks, HttpStatus.OK);
	}

	/**
	 * Method to add Feedback for a Tour.
	 * 
	 * @param takes a feedback object
	 * @param takes a int tourId
	 * @return returns added Feedback and HttpStatus:CREATED
	 */
	@PostMapping(value = "tours/{tourId}/feedbacks", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback, @PathVariable int tourId) {

		feedback.setTour(new Tour(tourId));

		return new ResponseEntity<Feedback>(feedbackService.addFeedback(feedback), HttpStatus.CREATED);
	}

	/**
	 * Method to delete a Feedback.
	 * 
	 * @param takes a int id
	 * @return returns HttpStatus:NO_CONTENT
	 */
	@DeleteMapping("feedbacks/{id}")
	public ResponseEntity<Object> deletFeedback(@PathVariable int id) {

		feedbackService.deleteFeedback(id);

		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

//	@GetMapping("/feedbacks")
//	public List<Feedback> getAllFeedbacks() {
//		return feedbackService.getAllFeedbacks();
//	}
//
//	@PostMapping("tours/{tourId}/feedbacks")
//	public void addFeedback(@Valid @RequestBody Feedback feedback, @PathVariable int tourId) {
//		feedback.setTour(new Tour(tourId));
//		feedbackService.addFeedback(feedback);
//	}
//
//	@DeleteMapping("feedbacks/{id}")
//	public void deletFeedback(@PathVariable int id) {
//		feedbackService.deleteFeedback(id);
//	}

}
