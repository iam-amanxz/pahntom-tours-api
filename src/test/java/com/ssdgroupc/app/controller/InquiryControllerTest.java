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

import com.ssdgroupc.app.entity.Inquiry;
import com.ssdgroupc.app.repository.InquiryRepository;
import com.ssdgroupc.app.service.InquiryService;

@SpringBootTest
class InquiryControllerTest {

	@Mock
	InquiryRepository repository;

	@InjectMocks
	InquiryService service;

	@Test
	void testGetAllInquires() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Inquiry(1, "About Tour", "Aman", "aman@gmail.com", "0767971071", "About Tour"),
						new Inquiry(2, "About Tour2", "John", "john@gmail.com", "0767971071", "About Tour2"))
				.collect(Collectors.toList()));

		assertEquals(2, service.getAllInquires().size());
	}

	@Test
	void testAddInquiry() {
		Inquiry i = new Inquiry(1, "About Tour", "Aman", "aman@gmail.com", "0767971071", "About Tour");
		when(repository.save(i)).thenReturn(i);
		assertEquals(i, service.addInquiry(i));
	}

	@Test
	void testDeleteInquiry() {
		Inquiry i = new Inquiry(1, "About Tour", "Aman", "aman@gmail.com", "0767971071", "About Tour");
		service.deleteInquiry(i.getInquiryId());
		verify(repository, times(1)).deleteById(i.getInquiryId());
	}

}
