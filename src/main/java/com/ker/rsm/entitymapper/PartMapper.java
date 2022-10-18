package com.ker.rsm.entitymapper;

import org.mapstruct.Mapper;

import com.ker.rsm.dto.PartDTO;
import com.ker.rsm.model.Part;

@Mapper
public interface PartMapper {
	Part toEntity(PartDTO dto);
	PartDTO toDto(Part entity);
}
