package com.ker.rsm.repo;

import org.springframework.data.repository.CrudRepository;

import com.ker.rsm.model.Question;

public interface QuestionRepo extends CrudRepository<Question, Long> {

}
