package com.ker.rsm.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ker.rsm.dto.QuestionDTO;
import com.ker.rsm.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuestionController {

	private final QuestionService questionService;

	@GetMapping("/question/{id}")
	ResponseEntity<QuestionDTO> getQuestion(@PathVariable Long id) {
		QuestionDTO questionDto = questionService.getQuestion(id);
		return ResponseEntity.ok(questionDto);
	}
	
	@PostMapping("/question/save")
	ResponseEntity<QuestionDTO> saveQuestion(@RequestBody QuestionDTO dto) throws Exception {
		QuestionDTO questionDto = questionService.saveQuestion(dto);
		return ResponseEntity.created(new URI("/question/save")).body(questionDto);
	}
	
	@DeleteMapping("/question/delete/{id}")
	ResponseEntity<Void> saveQuestion(@PathVariable Long id) throws Exception {
		questionService.deleteQuestion(id);
		return ResponseEntity.noContent().build();
	}

}
