package com.ssdgroupc.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssdgroupc.app.entity.GalleryItem;

/**
 * Date: May 26-2020 interface for GalleryItemRepository.
 * 
 * @author aman
 * @version 1.0
 * @category repositories
 *
 */
public interface GalleryItemRepository extends CrudRepository<GalleryItem, Integer> {

}
