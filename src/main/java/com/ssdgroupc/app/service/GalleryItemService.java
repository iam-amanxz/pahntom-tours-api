package com.ssdgroupc.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdgroupc.app.entity.GalleryItem;
import com.ssdgroupc.app.repository.GalleryItemRepository;

/**
 * Date: May 26-2020 Service class for GalleryItem.
 * 
 * @author aman
 * @version 1.0
 * @category Service
 */
@Service
public class GalleryItemService {

	/**
	 * Injects GalleryItemRepository
	 */
	@Autowired
	private GalleryItemRepository galleryItemRepository;

	/**
	 * Method to save a GalleryItem to data source
	 * 
	 * @param takes in a galleryItem object
	 * @return returns a GalleryItem
	 */
	public GalleryItem addGalleryItem(GalleryItem galleryItem) {
		return galleryItemRepository.save(galleryItem);
	}

	/**
	 * Method to get all gallery items from data source
	 * 
	 * @return returns a List of GalleryItems
	 */
	public List<GalleryItem> getAllGalleryItems() {
		List<GalleryItem> galleryItems = new ArrayList<>();
		galleryItemRepository.findAll().forEach(galleryItems::add);
		return galleryItems;
	}

	/**
	 * Method to delete a GalleryItem from data source
	 * 
	 * @param takes an int id
	 */
	public void deleteGalleryItem(int id) {
		galleryItemRepository.deleteById(id);
	}

}
