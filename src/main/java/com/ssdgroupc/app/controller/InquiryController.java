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

import com.ssdgroupc.app.entity.Inquiry;
import com.ssdgroupc.app.service.InquiryService;

import javassist.NotFoundException;

/**
 * Date: May 26-2020 REST controller class for Inquiry.
 * 
 * @author aman
 * @version 1.0
 * @category Controller
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class InquiryController {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Injects InquiryService class.
	 */
	@Autowired
	private InquiryService inquiryService;

	/**
	 * Method to get all Inquiry.
	 * 
	 * @return returns List of inquiries and HttpStatus:OK
	 * @throws NotFoundException
	 */
	@GetMapping(value = "/inquiries", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Inquiry>> getAllInquires() throws NotFoundException {

		List<Inquiry> items = inquiryService.getAllInquires();

		if (items.isEmpty()) {
			LOGGER.info("Inquiry records are empty");
			throw new NotFoundException("No inquiry records were found");
		}

		return new ResponseEntity<List<Inquiry>>(items, HttpStatus.OK);
	}

	/**
	 * Method to add an Inquiry.
	 * 
	 * @param takes an inquiry object
	 * @return returns the added Inquiry and HttpStatus:CREATED
	 */
	@PostMapping(value = "/inquiries", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Inquiry> addInquiry(@Valid @RequestBody Inquiry inquiry) {

		return new ResponseEntity<Inquiry>(inquiryService.addInquiry(inquiry), HttpStatus.CREATED);
	}

	/**
	 * Method to delete an Inquiry.
	 * 
	 * @param takes an int id
	 * @return HttpStatus:NO_CONTENT
	 */
	@DeleteMapping("/inquiries/{id}")
	public ResponseEntity<Object> deleteInquiry(@PathVariable(value = "id") int id) {

		inquiryService.deleteInquiry(id);

		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

//	@GetMapping("/inquiries")
//	public List<Inquiry> getAllInquires() {
//		return inquiryService.getAllInquires();
//	}
//
//	@PostMapping("/inquiries")
//	public void addInquiry(@Valid @RequestBody Inquiry inquiry) {
//		inquiryService.addInquiry(inquiry);
//	}
//
//	@DeleteMapping("/inquiries/{id}")
//	public void deleteInquiry(@PathVariable(value = "id") int id) {
//		inquiryService.deleteInquiry(id);
//	}

}
