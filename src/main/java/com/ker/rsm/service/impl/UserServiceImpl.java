package com.ker.rsm.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ker.rsm.dto.UserDTO;
import com.ker.rsm.entitymapper.UserMapper;
import com.ker.rsm.model.User;
import com.ker.rsm.repo.UserRepo;
import com.ker.rsm.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepo userRepo;

	private final UserMapper userMapper;

	@Override
	public UserDTO getUser(Long id) {
		User user = new User();
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			user = optionalUser.get();
			return userMapper.toDto(user);
		}
		else {
			return null;
		}
	}

	@Override
	public UserDTO saveUser(UserDTO dto) throws Exception {
		User user = new User();
		if (dto.getId() == null) {
			user = userMapper.toEntity(dto);
			user = userRepo.save(user);
		} else {
			log.error("id cannot be present for new entry");
			throw new Exception("id cannot be present for new entry");
		}
		return userMapper.toDto(user);
	}

	@Override
	public void deleteUser(Long id) throws Exception {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			userRepo.deleteById(id);
		} else {
			log.error("User with id {} not present", id);
			throw new Exception("User with id " + id + " not present");
		}
	}

}
