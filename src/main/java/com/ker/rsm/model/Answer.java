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
@Entity(name = "answer")
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

	@Id
	@SequenceGenerator(name = "seq_ans_id", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_ans_id")
	@Column(name = "ans_id")
	private Long id;
	
	@Column(name = "ans_desc", nullable = false)
    private String desc;
	
}
