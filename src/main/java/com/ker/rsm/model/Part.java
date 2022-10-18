package com.ker.rsm.model;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.SEQUENCE;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "part")
@NoArgsConstructor
@AllArgsConstructor
public class Part {

	@Id
	@SequenceGenerator(name = "seq_part_id", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "seq_part_id")
	@Column(name = "part_id")
	private Long id;

    @Column(name = "part_name", nullable = false)
    private String name;

    @Column(name = "part_desc")
    private String desc;
    
    @OneToMany(fetch = EAGER)
    private List<Question> questions;
}
