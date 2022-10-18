package com.ker.rsm.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ker.rsm.dto.AnswerDTO;
import com.ker.rsm.entitymapper.AnswerMapper;
import com.ker.rsm.model.Answer;
import com.ker.rsm.repo.AnswerRepo;
import com.ker.rsm.service.AnswerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class AnswerServiceImpl implements AnswerService {

	private final AnswerRepo answerRepo;

	private final AnswerMapper answerMapper;

	@Override
	public AnswerDTO getAnswer(Long id) {
		Answer answer = new Answer();
		Optional<Answer> optionalAnswer = answerRepo.findById(id);
		if (optionalAnswer.isPresent()) {
			answer = optionalAnswer.get();
			return answerMapper.toDto(answer);
		}
		else {
			return null;
		}
	}

	@Override
	public AnswerDTO saveAnswer(AnswerDTO dto) throws Exception {
		Answer answer = new Answer();
		if (dto.getId() == null) {
			answer = answerMapper.toEntity(dto);
			answer = answerRepo.save(answer);
		} else {
			log.error("id cannot be present for new entry");
			throw new Exception("id cannot be present for new entry");
		}
		return answerMapper.toDto(answer);
	}

	@Override
	public void deleteAnswer(Long id) throws Exception {
		Optional<Answer> answer = answerRepo.findById(id);
		if (answer.isPresent()) {
			answerRepo.deleteById(id);
		} else {
			log.error("Answer with id {} not present", id);
			throw new Exception("Answer with id " + id + " not present");
		}
	}

}
