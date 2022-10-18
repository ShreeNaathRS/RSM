package com.ker.rsm.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ker.rsm.dto.QuestionDTO;
import com.ker.rsm.entitymapper.QuestionMapper;
import com.ker.rsm.model.Question;
import com.ker.rsm.repo.QuestionRepo;
import com.ker.rsm.service.QuestionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

	private final QuestionRepo questionRepo;

	private final QuestionMapper questionMapper;

	@Override
	public QuestionDTO getQuestion(Long id) {
		Question question = new Question();
		Optional<Question> optionalQuestion = questionRepo.findById(id);
		if (optionalQuestion.isPresent()) {
			question = optionalQuestion.get();
			return questionMapper.toDto(question);
		}
		else {
			return null;
		}
	}

	@Override
	public QuestionDTO saveQuestion(QuestionDTO dto) throws Exception {
		Question question = new Question();
		if (dto.getId() == null) {
			question = questionMapper.toEntity(dto);
			question = questionRepo.save(question);
		} else {
			log.error("id cannot be present for new entry");
			throw new Exception("id cannot be present for new entry");
		}
		return questionMapper.toDto(question);
	}

	@Override
	public void deleteQuestion(Long id) throws Exception {
		Optional<Question> question = questionRepo.findById(id);
		if (question.isPresent()) {
			questionRepo.deleteById(id);
		} else {
			log.error("Question with id {} not present", id);
			throw new Exception("Question with id " + id + " not present");
		}
	}

}
