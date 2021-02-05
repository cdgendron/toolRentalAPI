package com.toolRentalAPI.repository;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.toolRentalAPI.entity.Rental;

public interface RentalRepository extends CrudRepository<Rental, Long> {

//	@Query("Select i.toolId, max(i.dateRented) FROM Rental i")
//	public Rental getLatestToolRentedById(long l); 
}
