package com.vehicle.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.parking.dto.UserDto;
import com.vehicle.parking.entity.User;
import com.vehicle.parking.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/registration")
	public ResponseEntity<User> userRegistration(@RequestBody UserDto userDto){
		return new ResponseEntity<User>(userService.register(userDto),HttpStatus.OK);
	}
	
	@GetMapping("/login/{name}")
	public ResponseEntity<String> userLogin(@PathVariable String name){
		return new ResponseEntity<String>(userService.userLogin(name),HttpStatus.OK);
	}
	
	@PostMapping("/request")
	public ResponseEntity<String> userRequest(int id){
		return new ResponseEntity<String>(userService.sendRequest(id),HttpStatus.OK);
	}
	
	@PutMapping("/release/{id}/{days}")
	public ResponseEntity<String> userRelease(@PathVariable int id, @PathVariable int days){
		return new ResponseEntity<String>(userService.releaseSlot(id,days), HttpStatus.OK);
	}
}
