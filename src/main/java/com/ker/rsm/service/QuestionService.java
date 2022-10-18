package com.ker.rsm.service;

import com.ker.rsm.dto.QuestionDTO;

public interface QuestionService {
	QuestionDTO getQuestion(Long id);
	QuestionDTO saveQuestion(QuestionDTO dto) throws Exception;
	void deleteQuestion(Long id) throws Exception;
}
