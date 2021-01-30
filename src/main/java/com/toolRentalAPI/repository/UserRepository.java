package com.toolRentalAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.toolRentalAPI.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findByUsername(String username);
}
