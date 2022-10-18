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

import com.ker.rsm.dto.UserDTO;
import com.ker.rsm.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/user/{id}")
	ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
		UserDTO userDto = userService.getUser(id);
		return ResponseEntity.ok(userDto);
	}
	
	@PostMapping("/user/save")
	ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO dto) throws Exception {
		UserDTO userDto = userService.saveUser(dto);
		return ResponseEntity.created(new URI("/user/save")).body(userDto);
	}
	
	@DeleteMapping("/user/delete/{id}")
	ResponseEntity<Void> saveUser(@PathVariable Long id) throws Exception {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

}
