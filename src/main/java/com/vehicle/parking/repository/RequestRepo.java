package com.vehicle.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.parking.entity.Request;

public interface RequestRepo extends JpaRepository<Request, Integer>{

}
