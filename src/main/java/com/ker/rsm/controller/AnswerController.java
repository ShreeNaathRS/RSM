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

import com.ker.rsm.dto.AnswerDTO;
import com.ker.rsm.service.AnswerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AnswerController {

	private final AnswerService answerService;

	@GetMapping("/answer/{id}")
	ResponseEntity<AnswerDTO> getAnswer(@PathVariable Long id) {
		AnswerDTO answerDto = answerService.getAnswer(id);
		return ResponseEntity.ok(answerDto);
	}
	
	@PostMapping("/answer/save")
	ResponseEntity<AnswerDTO> saveAnswer(@RequestBody AnswerDTO dto) throws Exception {
		AnswerDTO answerDto = answerService.saveAnswer(dto);
		return ResponseEntity.created(new URI("/answer/save")).body(answerDto);
	}
	
	@DeleteMapping("/answer/delete/{id}")
	ResponseEntity<Void> saveAnswer(@PathVariable Long id) throws Exception {
		answerService.deleteAnswer(id);
		return ResponseEntity.noContent().build();
	}

}
