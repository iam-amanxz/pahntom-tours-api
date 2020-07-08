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

import com.ssdgroupc.app.entity.GalleryItem;
import com.ssdgroupc.app.service.GalleryItemService;

import javassist.NotFoundException;

/**
 * Date: May 26-2020 REST controller class for GalleryItem.
 * 
 * @author aman
 * @version 1.0
 * @category Controller
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class GalleryItemController {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Injects GalleryItemService class.
	 */
	@Autowired
	private GalleryItemService galleryItemService;

	/**
	 * Method to get all GalleryItems.
	 * 
	 * @return returns List of gallery items and HttpStatus:OK
	 * @throws NotFoundException
	 */
	@GetMapping(value = "/galleryItems", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GalleryItem>> getAllGalleryItems() throws NotFoundException {

		List<GalleryItem> items = galleryItemService.getAllGalleryItems();

		if (items.isEmpty()) {
			LOGGER.info("Gallery records are empty");
			throw new NotFoundException("No gallery records were found");
		}

		return new ResponseEntity<List<GalleryItem>>(items, HttpStatus.OK);
	}

	/**
	 * Method to add a GalleryItem.
	 * 
	 * @param takes a galleryItem object
	 * @return returns the added GalleryItem and HttpStatus:CREATED
	 */
	@PostMapping(value = "/galleryItems", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GalleryItem> addGalleryItem(@Valid @RequestBody GalleryItem galleryItem) {

		return new ResponseEntity<GalleryItem>(galleryItemService.addGalleryItem(galleryItem), HttpStatus.CREATED);
	}

	/**
	 * Method to delete a GalleryItem.
	 * 
	 * @param takes an int id
	 * @return HttpStatus:NO_CONTENT
	 */
	@DeleteMapping("/galleryItems/{id}")
	public ResponseEntity<Object> deleteGalleryItem(@PathVariable(value = "id") int id) {

		galleryItemService.deleteGalleryItem(id);

		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

//	@GetMapping("/galleryItems")
//	public List<GalleryItem> getAllGalleryItems() {
//		return galleryItemService.getAllGalleryItems();
//	}
//
//	@PostMapping("/galleryItems")
//	public void addGalleryItem(@Valid @RequestBody GalleryItem galleryItem) {
//		galleryItemService.addGalleryItem(galleryItem);
//	}
//
//	@DeleteMapping("/galleryItems/{id}")
//	public void deleteGalleryItem(@PathVariable(value = "id") int id) {
//		galleryItemService.deleteGalleryItem(id);
//	}

}
