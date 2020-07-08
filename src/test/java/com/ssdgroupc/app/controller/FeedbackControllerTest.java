package com.ssdgroupc.app.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssdgroupc.app.entity.Feedback;
import com.ssdgroupc.app.repository.FeedbackRepository;
import com.ssdgroupc.app.service.FeedbackService;

@SpringBootTest
class FeedbackControllerTest {

	@Mock
	private FeedbackRepository repository;

	@InjectMocks
	private FeedbackService service;

	@Test
	void testAddFeedback() {
		Feedback feedback = new Feedback(1, 5, "Nice");
		when(repository.save(feedback)).thenReturn(feedback);
		assertEquals(feedback, service.addFeedback(feedback));
	}

	@Test
	void testGetAllFeedbacks() {
		when(repository.findAll()).thenReturn(
				Stream.of(new Feedback(1, 5, "Nice"), new Feedback(2, 4, "Great")).collect(Collectors.toList()));

		assertEquals(2, service.getAllFeedbacks().size());
	}

	@Test
	void testDeleteFeedback() {
		Feedback feedback = new Feedback(2, 4, "Great");
		service.deleteFeedback(feedback.getFeedbackId());
		verify(repository, times(1)).deleteById(feedback.getFeedbackId());
	}

}
