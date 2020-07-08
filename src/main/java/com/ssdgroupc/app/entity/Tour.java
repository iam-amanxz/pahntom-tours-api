package com.ssdgroupc.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Date: May 26-2020 Entity class for Tour.
 * 
 * @author aman
 * @version 1.0
 * @category Entity
 */
@Entity
@Table(name = "TOURS")
public class Tour {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tourId;
	@NotNull
	private String tourTitle;
	@NotNull
	@Lob
	@Column(length = 2500)
	private String tourDescription;
	@NotNull
	@Column(length = 250)
	private String tourLocationImageLink;
	@NotNull
	private int tourDays;
	@NotNull
	private double tourDistance;
	@NotNull
	private double tourPrice;
	@NotNull
	private int tourGroupSize;
	@NotNull
	private String tourTerrain;
	@NotNull
	private String tourStartingPoint;
	@NotNull
	private String tourEndingPoint;
	@NotNull
	private boolean tourAvailability;
	@NotNull
	@Column(length = 250)
	private String tourRouteMapLink;

	public Tour() {
		super();
	}

	public Tour(int tourId) {
		this.tourId = tourId;
	}
	
	

//	public Tour(int tourId, int tourGroupSize, int tourDays, double tourDistance, double tourPrice,
//			boolean tourAvailability, String tourTitle, String tourDescription, String tourTerrain,
//			String tourStartingPoint, String tourEndingPoint, String tourLocationImageLink, String tourRouteMapLink) {
//		super();
//		this.tourId = tourId;
//		this.tourGroupSize = tourGroupSize;
//		this.tourDays = tourDays;
//		this.tourDistance = tourDistance;
//		this.tourPrice = tourPrice;
//		this.tourAvailability = tourAvailability;
//		this.tourTitle = tourTitle;
//		this.tourDescription = tourDescription;
//		this.tourTerrain = tourTerrain;
//		this.tourStartingPoint = tourStartingPoint;
//		this.tourEndingPoint = tourEndingPoint;
//		this.tourLocationImageLink = tourLocationImageLink;
//		this.tourRouteMapLink = tourRouteMapLink;
//	}

	public Tour(int tourId, @NotNull String tourTitle, @NotNull String tourDescription,
			@NotNull String tourLocationImageLink, @NotNull int tourDays, @NotNull double tourDistance,
			@NotNull double tourPrice, @NotNull int tourGroupSize, @NotNull String tourTerrain,
			@NotNull String tourStartingPoint, @NotNull String tourEndingPoint, @NotNull boolean tourAvailability,
			@NotNull String tourRouteMapLink) {
		super();
		this.tourId = tourId;
		this.tourTitle = tourTitle;
		this.tourDescription = tourDescription;
		this.tourLocationImageLink = tourLocationImageLink;
		this.tourDays = tourDays;
		this.tourDistance = tourDistance;
		this.tourPrice = tourPrice;
		this.tourGroupSize = tourGroupSize;
		this.tourTerrain = tourTerrain;
		this.tourStartingPoint = tourStartingPoint;
		this.tourEndingPoint = tourEndingPoint;
		this.tourAvailability = tourAvailability;
		this.tourRouteMapLink = tourRouteMapLink;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public int getTourGroupSize() {
		return tourGroupSize;
	}

	public void setTourGroupSize(int tourGroupSize) {
		this.tourGroupSize = tourGroupSize;
	}

	public int getTourDays() {
		return tourDays;
	}

	public void setTourDays(int tourDays) {
		this.tourDays = tourDays;
	}

	public double getTourDistance() {
		return tourDistance;
	}

	public void setTourDistance(double tourDistance) {
		this.tourDistance = tourDistance;
	}

	public double getTourPrice() {
		return tourPrice;
	}

	public void setTourPrice(double tourPrice) {
		this.tourPrice = tourPrice;
	}

	public boolean isTourAvailability() {
		return tourAvailability;
	}

	public void setTourAvailability(boolean tourAvailability) {
		this.tourAvailability = tourAvailability;
	}

	public String getTourTitle() {
		return tourTitle;
	}

	public void setTourTitle(String tourTitle) {
		this.tourTitle = tourTitle;
	}

	public String getTourDescription() {
		return tourDescription;
	}

	public void setTourDescription(String tourDescription) {
		this.tourDescription = tourDescription;
	}

	public String getTourTerrain() {
		return tourTerrain;
	}

	public void setTourTerrain(String tourTerrain) {
		this.tourTerrain = tourTerrain;
	}

	public String getTourStartingPoint() {
		return tourStartingPoint;
	}

	public void setTourStartingPoint(String tourStartingPoint) {
		this.tourStartingPoint = tourStartingPoint;
	}

	public String getTourEndingPoint() {
		return tourEndingPoint;
	}

	public void setTourEndingPoint(String tourEndingPoint) {
		this.tourEndingPoint = tourEndingPoint;
	}

	public String getTourLocationImageLink() {
		return tourLocationImageLink;
	}

	public void setTourLocationImageLink(String tourLocationImageLink) {
		this.tourLocationImageLink = tourLocationImageLink;
	}

	public String getTourRouteMapLink() {
		return tourRouteMapLink;
	}

	public void setTourRouteMapLink(String tourRouteMapLink) {
		this.tourRouteMapLink = tourRouteMapLink;
	}
}
