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

import com.ssdgroupc.app.entity.Carousel;
import com.ssdgroupc.app.repository.CarouselRepository;
import com.ssdgroupc.app.service.CarouselService;

@SpringBootTest
class CarouselControllerTest {

	@Mock
	private CarouselRepository repository;

	@InjectMocks
	private CarouselService service;

	@Test
	void testGetAllCarousel() {
		when(repository.findAll())
				.thenReturn(Stream.of(new Carousel(1, "link1"), new Carousel(2, "Link2")).collect(Collectors.toList()));

		assertEquals(2, service.getAllCarousels().size());
	}

	@Test
	void testAddCarousel() {
		Carousel carousel = new Carousel(1, "link3");
		when(repository.save(carousel)).thenReturn(carousel);
		assertEquals(carousel, service.addCarousel(carousel));
	}

	@Test
	void testDeletCarousel() {
		Carousel carousel = new Carousel(1, "link3");
		service.deleteCarousel(carousel.getCarouselId());
		verify(repository, times(1)).deleteById(carousel.getCarouselId());
	}

}
