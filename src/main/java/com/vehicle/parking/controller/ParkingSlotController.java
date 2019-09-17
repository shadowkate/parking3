package com.vehicle.parking.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.parking.service.ParkingSlotService;
import com.vehicle.parking.service.UserService;

@RestController
@RequestMapping("/admin")
@EnableScheduling
public class ParkingSlotController {
	@Autowired
	ParkingSlotService parkingSlotService;

	@Autowired
	UserService userService;

	@PostMapping("/assignSlot")
	public String assignSlots() {
		return parkingSlotService.assignSlotList();
	}
	
	@PutMapping("/dailySlots")
	@Scheduled(fixedRate = 200000)
	public String assignDailySlots() {
		System.out.println("start"+new Date());
		return parkingSlotService.assignDailySlot();
		
	}

}
