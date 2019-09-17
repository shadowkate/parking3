package com.vehicle.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicle.parking.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	public User findByName(String name);
	
}
