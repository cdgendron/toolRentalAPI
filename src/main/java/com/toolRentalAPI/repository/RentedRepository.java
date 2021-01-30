package com.toolRentalAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.toolRentalAPI.entity.Rented;

public interface RentedRepository extends CrudRepository<Rented, Long> {

}
