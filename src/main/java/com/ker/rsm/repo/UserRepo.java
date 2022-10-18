package com.ker.rsm.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ker.rsm.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

}
