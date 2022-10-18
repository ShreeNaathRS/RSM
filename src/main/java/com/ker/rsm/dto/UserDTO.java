package com.ker.rsm.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String userName;
	private String password;
	private String email;
	private String phoneNumber;
	private String vessel;

}
