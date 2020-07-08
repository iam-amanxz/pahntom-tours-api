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

import com.ssdgroupc.app.entity.GalleryItem;
import com.ssdgroupc.app.repository.GalleryItemRepository;
import com.ssdgroupc.app.service.GalleryItemService;

@SpringBootTest
class GalleryItemControllerTest {

	@Mock
	GalleryItemRepository repository;

	@InjectMocks
	GalleryItemService service;

	@Test
	void testGetAllGalleryItems() {
		when(repository.findAll()).thenReturn(
				Stream.of(new GalleryItem(1, "Link"), new GalleryItem(2, "Link1")).collect(Collectors.toList()));

		assertEquals(2, service.getAllGalleryItems().size());
	}

	@Test
	void testAddGalleryItem() {
		GalleryItem gi = new GalleryItem(1, "Link3");
		when(repository.save(gi)).thenReturn(gi);
		assertEquals(gi, service.addGalleryItem(gi));
	}

	@Test
	void testDeleteGalleryItem() {
		GalleryItem gi = new GalleryItem(2, "Link4");
		service.deleteGalleryItem(gi.getGalleryItemId());
		verify(repository, times(1)).deleteById(gi.getGalleryItemId());
	}

}
