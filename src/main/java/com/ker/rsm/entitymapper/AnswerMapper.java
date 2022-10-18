package com.ker.rsm.entitymapper;

import org.mapstruct.Mapper;

import com.ker.rsm.dto.AnswerDTO;
import com.ker.rsm.model.Answer;

@Mapper
public interface AnswerMapper {
	Answer toEntity(AnswerDTO dto);
	AnswerDTO toDto(Answer dto);
}
