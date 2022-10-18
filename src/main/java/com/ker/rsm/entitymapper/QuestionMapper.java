package com.ker.rsm.entitymapper;

import org.mapstruct.Mapper;

import com.ker.rsm.dto.QuestionDTO;
import com.ker.rsm.model.Question;

@Mapper
public interface QuestionMapper {
	Question toEntity(QuestionDTO dto);
	QuestionDTO toDto(Question entity);
}
