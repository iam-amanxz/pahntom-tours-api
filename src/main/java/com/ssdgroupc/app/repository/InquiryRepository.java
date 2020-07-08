package com.ssdgroupc.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssdgroupc.app.entity.Inquiry;

/**
 * Date: May 26-2020 interface for InquiryRepository.
 * 
 * @author aman
 * @version 1.0
 * @category repositories
 *
 */
public interface InquiryRepository extends CrudRepository<Inquiry, Integer> {

}
