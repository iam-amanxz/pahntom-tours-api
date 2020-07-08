package com.ssdgroupc.app.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssdgroupc.app.entity.Bike;
import com.ssdgroupc.app.repository.BikeRepository;
import com.ssdgroupc.app.service.BikeService;

@SpringBootTest
class BikeControllerTest {

	@Mock
	private BikeRepository repository;

	@InjectMocks
	private BikeService service;

	@Test
	void getAllBikesTest() {
		when(repository.findAll())
				.thenReturn(Stream.of(new Bike(1, "Bike1", "Desc1", "Link1"), new Bike(2, "Bike2", "Desc2", "Link2"))
						.collect(Collectors.toList()));

		assertEquals(2, service.getAllBikes().size());
	}

	@Test
	void addBikeTest() {
		Bike bike = new Bike(1, "Bike1", "Desc1", "Link1");
		when(repository.save(bike)).thenReturn(bike);
		assertEquals(bike, service.addBike(bike));
	}

	@Test
	void deleteBikeTest() {
		Bike bike = new Bike(1, "Bike1", "Desc1", "Link1");
		service.deleteBike(bike.getBikeId());
		verify(repository, times(1)).deleteById(bike.getBikeId());
	}

}
