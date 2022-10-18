package com.ker.rsm.service;

import com.ker.rsm.dto.UserDTO;

public interface UserService {
	UserDTO getUser(Long id);
	UserDTO saveUser(UserDTO dto) throws Exception;
	void deleteUser(Long id) throws Exception;
}
