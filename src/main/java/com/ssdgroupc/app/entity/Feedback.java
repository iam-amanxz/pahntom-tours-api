package com.ssdgroupc.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Date: May 26-2020 Entity class for Feedback.
 * 
 * @author aman
 * @version 1.0
 * @category Entity
 */
@Entity
@Table(name = "FEEDBACKS")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;
	@NotNull
	private int feedbackStars;
	@NotNull
	@Lob
	@Column(length = 500)
	private String feedbackBody;
	@ManyToOne
	private Tour tour;
	@NotNull
	private String username;

	public Feedback() {
		super();
	}

	public Feedback(int feedbackId, int feedbackStars, String feedbackBody, Tour tour, String username) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackStars = feedbackStars;
		this.feedbackBody = feedbackBody;
		this.tour = tour;
		this.username = username;
	}

	public Feedback(int feedbackId, int feedbackStars, String feedbackBody, Tour tour) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackStars = feedbackStars;
		this.feedbackBody = feedbackBody;
		this.tour = tour;
	}

	public Feedback(int feedbackId, int feedbackStars, String feedbackBody) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackStars = feedbackStars;
		this.feedbackBody = feedbackBody;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackBody() {
		return feedbackBody;
	}

	public void setFeedbackBody(String feedbackBody) {
		this.feedbackBody = feedbackBody;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public int getFeedbackStars() {
		return feedbackStars;
	}

	public void setFeedbackStars(int feedbackStars) {
		this.feedbackStars = feedbackStars;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
