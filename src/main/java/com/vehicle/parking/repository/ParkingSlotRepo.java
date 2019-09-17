package com.vehicle.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vehicle.parking.entity.ParkingSlot;

@Repository
public interface ParkingSlotRepo extends JpaRepository<ParkingSlot, Integer>{
	
	@Query(value="SELECT * FROM parking_slot where user_id=?1", nativeQuery = true)
	public ParkingSlot findByUserId(int id);
}
