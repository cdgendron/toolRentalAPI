package com.toolRentalAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.toolRentalAPI.entity.Rental;

public interface RentalRepository extends CrudRepository<Rental, Long> {

}
