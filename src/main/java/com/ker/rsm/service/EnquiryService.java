package com.ker.rsm.service;

import com.ker.rsm.dto.EnquiryDTO;

public interface EnquiryService {
	EnquiryDTO getEnquiry(Long id);
	EnquiryDTO saveEnquiry(EnquiryDTO dto) throws Exception;
	void deleteEnquiry(Long id) throws Exception;
}
