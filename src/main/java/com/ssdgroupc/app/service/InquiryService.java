package com.ssdgroupc.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdgroupc.app.entity.Inquiry;
import com.ssdgroupc.app.repository.InquiryRepository;

/**
 * Date: May 26-2020 Service class for Inquiry.
 * 
 * @author aman
 * @version 1.0
 * @category Service
 */
@Service
public class InquiryService {

	/**
	 * Injects InquiryRepository
	 */
	@Autowired
	private InquiryRepository inquiryRepository;

	/**
	 * Method to save a Inquiry to data source
	 * 
	 * @param takes in a inquiry object
	 * @return returns a Inquiry
	 */
	public Inquiry addInquiry(Inquiry inquiry) {
		return inquiryRepository.save(inquiry);
	}

	/**
	 * Method to get all inquiries from data source
	 * 
	 * @return returns a List of Inquiries
	 */
	public List<Inquiry> getAllInquires() {
		List<Inquiry> inquiries = new ArrayList<>();
		inquiryRepository.findAll().forEach(inquiries::add);
		return inquiries;
	}

	/**
	 * Method to delete an Inquiry from data source
	 * 
	 * @param takes an int id
	 */
	public void deleteInquiry(int id) {
		inquiryRepository.deleteById(id);
	}

}
