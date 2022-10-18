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
@Entity(name = "enquiry")
@NoArgsConstructor
@AllArgsConstructor
public class Enquiry {

	@Id
	@SequenceGenerator(name = "seq_enq_id", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_enq_id")
	@Column(name = "enq_id")
	private Long id;

	@Column(name = "enq_subject")
	private Long subject;

	@Column(name = "enq_message")
	private Long message;

}
