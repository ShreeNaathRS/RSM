package com.ker.rsm.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long subject;
	private Long message;

}
