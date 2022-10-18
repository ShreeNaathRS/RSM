package com.ker.rsm.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ker.rsm.dto.EnquiryDTO;
import com.ker.rsm.entitymapper.EnquiryMapper;
import com.ker.rsm.model.Enquiry;
import com.ker.rsm.repo.EnquiryRepo;
import com.ker.rsm.service.EnquiryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class EnquiryServiceImpl implements EnquiryService {

	private final EnquiryRepo enquiryRepo;

	private final EnquiryMapper enquiryMapper;

	@Override
	public EnquiryDTO getEnquiry(Long id) {
		Enquiry enquiry = new Enquiry();
		Optional<Enquiry> optionalEnquiry = enquiryRepo.findById(id);
		if (optionalEnquiry.isPresent()) {
			enquiry = optionalEnquiry.get();
			return enquiryMapper.toDto(enquiry);
		}
		else {
			return null;
		}
	}

	@Override
	public EnquiryDTO saveEnquiry(EnquiryDTO dto) throws Exception {
		Enquiry enquiry = new Enquiry();
		if (dto.getId() == null) {
			enquiry = enquiryMapper.toEntity(dto);
			enquiry = enquiryRepo.save(enquiry);
		} else {
			log.error("id cannot be present for new entry");
			throw new Exception("id cannot be present for new entry");
		}
		return enquiryMapper.toDto(enquiry);
	}

	@Override
	public void deleteEnquiry(Long id) throws Exception {
		Optional<Enquiry> enquiry = enquiryRepo.findById(id);
		if (enquiry.isPresent()) {
			enquiryRepo.deleteById(id);
		} else {
			log.error("Enquiry with id {} not present", id);
			throw new Exception("Enquiry with id " + id + " not present");
		}
	}

}
