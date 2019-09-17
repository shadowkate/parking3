package com.vehicle.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.parking.entity.ParkingSlot;
import com.vehicle.parking.entity.Request;
import com.vehicle.parking.entity.User;
import com.vehicle.parking.repository.ParkingSlotRepo;
import com.vehicle.parking.repository.RequestRepo;
import com.vehicle.parking.repository.UserRepo;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ParkingSlotRepo parkingSlotRepo;
	
	@Autowired
	RequestRepo requestRepo;
	
	User user = null;
	@Override
	public String assignSlotList() {
		List<User> list = userRepo.findAll();
		user = new User();
		for(User user :list) {
			if(user.getDesignation().equalsIgnoreCase("senior") || user.getDesignation().equalsIgnoreCase("official")) {
				ParkingSlot	parkingSlot = new ParkingSlot();
				parkingSlot.setUser(user);
				parkingSlot.setSlotId(0);
				parkingSlot.setFloor("first floor");
				parkingSlotRepo.save(parkingSlot);
			}
		}
		return "slots alloted successfully";
	}
	@Override
	public String assignDailySlot() {
		int arr[] = new int[5];
		int i = 0;
		List<ParkingSlot> list = parkingSlotRepo.findAll();
		for(ParkingSlot slot : list) {
			if(slot.getStatus()==1) {
				arr[i] = slot.getSlotId();
				if(slot.getDays()!=0) {
				int a = slot.getDays()-1;
					slot.setDays(a);
					if(a==0) {
						slot.setStatus(0);
						}
					parkingSlotRepo.save(slot);
				}
				i++;
			}
			i=0;
			List<Request> re = requestRepo.findAll();
			for(Request r : re) {
				r.setSlotId(arr[i]);
				requestRepo.save(r);
				i++;
			}
		}
		return "assign the daily slots successfully";
	}

}
