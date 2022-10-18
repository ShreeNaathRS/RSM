package com.ker.rsm.entitymapper;

import org.mapstruct.Mapper;

import com.ker.rsm.dto.UserDTO;
import com.ker.rsm.model.User;

@Mapper
public interface UserMapper {
	User toEntity(UserDTO dto);
	UserDTO toDto(User user);
}
