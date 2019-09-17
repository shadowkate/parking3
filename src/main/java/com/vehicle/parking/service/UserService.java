package com.vehicle.parking.service;

import org.springframework.stereotype.Service;

import com.vehicle.parking.dto.UserDto;
import com.vehicle.parking.entity.User;

@Service
public interface UserService {

	User register(UserDto userDto);

	String sendRequest(int id);

	String releaseSlot(int id, int days);

	String userLogin(String name);

}
