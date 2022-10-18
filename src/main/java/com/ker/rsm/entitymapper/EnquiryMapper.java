package com.ker.rsm.entitymapper;

import org.mapstruct.Mapper;

import com.ker.rsm.dto.EnquiryDTO;
import com.ker.rsm.model.Enquiry;

@Mapper
public interface EnquiryMapper {
	Enquiry toEntity(EnquiryDTO dto);
	EnquiryDTO toDto(Enquiry entity);
}
