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

import com.ker.rsm.dto.PartDTO;
import com.ker.rsm.service.PartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PartController {

	private final PartService partService;

	@GetMapping("/part/{id}")
	ResponseEntity<PartDTO> getPart(@PathVariable Long id) {
		PartDTO partDto = partService.getPart(id);
		return ResponseEntity.ok(partDto);
	}
	
	@PostMapping("/part/save")
	ResponseEntity<PartDTO> savePart(@RequestBody PartDTO dto) throws Exception {
		PartDTO partDto = partService.savePart(dto);
		return ResponseEntity.created(new URI("/part/save")).body(partDto);
	}
	
	@DeleteMapping("/part/delete/{id}")
	ResponseEntity<Void> savePart(@PathVariable Long id) throws Exception {
		partService.deletePart(id);
		return ResponseEntity.noContent().build();
	}

}
