package com.vehicle.parking.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.vehicle.parking.dto.UserDto;
import com.vehicle.parking.entity.ParkingSlot;
import com.vehicle.parking.entity.Request;
import com.vehicle.parking.entity.User;
import com.vehicle.parking.repository.ParkingSlotRepo;
import com.vehicle.parking.repository.RequestRepo;
import com.vehicle.parking.repository.UserRepo;

@RunWith(MockitoJUnitRunner.class)
public class ParkingSlotServiceImplTest {
	
	@InjectMocks
	ParkingSlotServiceImpl parkingSlotServiceImpl;
	
	@Mock
	UserRepo userRepo;
	
	@Mock
	ParkingSlotRepo parkingSlotRepo;
	
	@Mock
	RequestRepo requestRepo;
		
	static UserDto user = null;
	static User use = null;
	
	@BeforeClass
	public static void setUp(){
		 user = new UserDto();
		user.setId(1);
		user.setName("mahesh");
		user.setExperience(15);
		user.setAddress("Bangalore");
		user.setDesignation("manager");
		user.setMobileno(98L);
		User use = new User();
		BeanUtils.copyProperties(user, use);
	}
	
	
	@Test
	public void testAssignSlotList() {
		List<User> list = new ArrayList<>();
		UserDto user = new UserDto();
		user.setId(1);
		user.setName("mahesh");
		user.setExperience(15);
		user.setAddress("Bangalore");
		user.setDesignation("manager");
		user.setMobileno(98L);
		User use = new User();
		BeanUtils.copyProperties(user, use);
		list.add(use);
		ParkingSlot	parkingSlot = new ParkingSlot();
		parkingSlot.setUser(use);
		parkingSlot.setSlotId(0);
		parkingSlot.setFloor("first floor");
		Mockito.when(parkingSlotRepo.save(Mockito.any())).thenReturn("slots alloted successfully");
		Mockito.when(userRepo.findAll()).thenReturn(list);
		String s = parkingSlotServiceImpl.assignSlotList();
		assertEquals("slots alloted successfully", s);
	}

	@Test
	public void testAssignDailySlot() {
		List<ParkingSlot> list = new ArrayList<>();
		ParkingSlot	parkingSlot = new ParkingSlot();
		parkingSlot.setUser(use);
		parkingSlot.setSlotId(0);
		parkingSlot.setFloor("first floor");
		parkingSlot.setSlotId(1);
		List<Request> re = new ArrayList<>();
		Request re1 = new Request();
		re1.setId(1);re1.setSlotId(0);re1.setUser(use);
		Mockito.when(requestRepo.save(Mockito.any())).thenReturn("assign the daily slots successfully");
		Mockito.when(requestRepo.findAll()).thenReturn(re);
		
		Mockito.when(parkingSlotRepo.save(Mockito.any())).thenReturn("slots alloted successfully");
		Mockito.when(parkingSlotRepo.findAll()).thenReturn(list);
		String s = parkingSlotServiceImpl.assignDailySlot();
		assertEquals("assign the daily slots successfully", s);
		
	}

}
