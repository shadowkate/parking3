package com.vehicle.parking.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.parking.dto.UserDto;
import com.vehicle.parking.entity.ParkingSlot;
import com.vehicle.parking.entity.Request;
import com.vehicle.parking.entity.User;
import com.vehicle.parking.repository.ParkingSlotRepo;
import com.vehicle.parking.repository.RequestRepo;
import com.vehicle.parking.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	ParkingSlotRepo parkingSlotRepo;

	@Autowired
	RequestRepo requestRepo;

	@Override
	public User register(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		return userRepo.save(user);
	}

	@Override
	public String sendRequest(int id) {
		User u = userRepo.findById(id).get();
		Request re = new Request();
		re.setUser(u);
		requestRepo.save(re);
		return "your request send successfully";
		/*
		 * else return "your request not send...try agian";
		 */
	}


	@Override
	public String releaseSlot(int id, int days) {
		ParkingSlot ps = parkingSlotRepo.findByUserId(id);
		ps.setStatus(1);
		ps.setDays(days);
		parkingSlotRepo.save(ps);
		return "your slot released successfully";
	}

	@Override
	public String userLogin(String name) {
		User user = userRepo.findByName(name);
		if (user.getName().equalsIgnoreCase(name))
			return "login successfully";
		else
			return "Invalid credentials...";
	}

}
