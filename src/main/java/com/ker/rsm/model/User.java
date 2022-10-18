package com.ker.rsm.model;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "login_user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@SequenceGenerator(name = "seq_user_id", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_user_id")
	@Column(name = "user_id")
	private Long id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_pwd")
	private String password;

	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_phno")
	private String phoneNumber;
	
	@Column(name = "user_vessel")
	private String vessel;
}
