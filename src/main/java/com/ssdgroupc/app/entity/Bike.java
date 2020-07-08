package com.ssdgroupc.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/**
 * Date: May 26-2020 Entity class for Bike.
 * 
 * @author aman
 * @version 1.0
 * @category Entity
 */
@Entity
@Table(name = "BIKES")
public class Bike {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bikeId;
	@NotNull
	private String bikeName;
	@Lob
	@Column(length = 1000)
	private String bikeDescription;
	@NotNull
	@Column(length = 500)
	private String bikeImageLink;

	public Bike(int bikeId, String bikeName, String bikeDescription, String imageLink) {
		super();
		this.bikeId = bikeId;
		this.bikeName = bikeName;
		this.bikeDescription = bikeDescription;
		this.bikeImageLink = imageLink;
	}

	public Bike() {
		super();
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public String getBikeDescription() {
		return bikeDescription;
	}

	public void setBikeDescription(String bikeDescription) {
		this.bikeDescription = bikeDescription;
	}

	public String getBikeImageLink() {
		return bikeImageLink;
	}

	public void setBikeImageLink(String imageLink) {
		this.bikeImageLink = imageLink;
	}

}
