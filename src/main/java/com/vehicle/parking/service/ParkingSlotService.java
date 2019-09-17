package com.vehicle.parking.service;

import org.springframework.stereotype.Service;

@Service
public interface ParkingSlotService {

	String assignSlotList();

	String assignDailySlot();

}
