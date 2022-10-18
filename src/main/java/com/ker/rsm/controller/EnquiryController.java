package com.ker.rsm.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ker.rsm.dto.EnquiryDTO;
import com.ker.rsm.service.EnquiryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EnquiryController {

	private final EnquiryService enquiryService;

	@GetMapping("/enquiry/{id}")
	ResponseEntity<EnquiryDTO> getEnquiry(@PathVariable Long id) {
		EnquiryDTO enquiryDto = enquiryService.getEnquiry(id);
		return ResponseEntity.ok(enquiryDto);
	}
	
	@PostMapping("/enquiry/save")
	ResponseEntity<EnquiryDTO> saveEnquiry(@RequestBody EnquiryDTO dto) throws Exception {
		EnquiryDTO enquiryDto = enquiryService.saveEnquiry(dto);
		return ResponseEntity.created(new URI("/enquiry/save")).body(enquiryDto);
	}
	
	@DeleteMapping("/enquiry/delete/{id}")
	ResponseEntity<Void> saveEnquiry(@PathVariable Long id) throws Exception {
		enquiryService.deleteEnquiry(id);
		return ResponseEntity.noContent().build();
	}

}
