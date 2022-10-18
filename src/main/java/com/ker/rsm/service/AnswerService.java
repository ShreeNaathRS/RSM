package com.ker.rsm.service;

import com.ker.rsm.dto.AnswerDTO;

public interface AnswerService {
	AnswerDTO getAnswer(Long id);
	AnswerDTO saveAnswer(AnswerDTO dto) throws Exception;
	void deleteAnswer(Long id) throws Exception;
}
