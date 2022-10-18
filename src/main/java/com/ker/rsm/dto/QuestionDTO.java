package com.ker.rsm.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String desc;
	private List<AnswerDTO> answers;

}
