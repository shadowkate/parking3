package com.vehicle.parking.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.vehicle.parking.dto.UserDto;
import com.vehicle.parking.entity.ParkingSlot;
import com.vehicle.parking.entity.User;
import com.vehicle.parking.repository.ParkingSlotRepo;
import com.vehicle.parking.repository.RequestRepo;
import com.vehicle.parking.repository.UserRepo;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@Before
	public void setUp() {

	}

	@InjectMocks
	UserServiceImpl userService;

	@Mock
	UserRepo userRepo;

	@Mock
	RequestRepo requestRepo;

	@Mock
	ParkingSlotRepo parkingSlotRepo;

	@Test
	public void testRegister() {
		UserDto user = new UserDto();
		user.setId(1);
		user.setName("mahesh");
		user.setExperience(15);
		user.setAddress("Bangalore");
		user.setDesignation("manager");
		user.setMobileno(98L);
		User use = new User();
		BeanUtils.copyProperties(user, use);
		Mockito.when(userRepo.save(Mockito.any())).thenReturn(use);
		User use1 = userService.register(user);
		assertEquals(use1.getName(), use.getName());
	}

	@Test
	public void testUSerLogin() {
		UserDto user = new UserDto();
		user.setId(1);
		user.setName("mahesh");
		user.setExperience(15);
		user.setAddress("Bangalore");
		user.setDesignation("manager");
		user.setMobileno(98L);
		User use = new User();
		BeanUtils.copyProperties(user, use);
		Mockito.when(userRepo.findByName(Mockito.anyString())).thenReturn(use);
		String s = userService.userLogin(use.getName());
		assertEquals("login successfully", s);
	}

	@Test
	public void testNegativeUSerLogin() {
		UserDto user = new UserDto();
		user.setId(1);
		user.setName("mahesh");
		user.setExperience(15);
		user.setAddress("Bangalore");
		user.setDesignation("manager");
		user.setMobileno(98L);
		User use = new User();
		BeanUtils.copyProperties(user, use);
		Mockito.when(userRepo.findByName(Mockito.anyString())).thenReturn(use);
		String s = userService.userLogin("gowtham");
		assertEquals("Invalid credentials...", s);
	}

	/*
	 * @Test public void testSendRequest() { UserDto user = new UserDto();
	 * user.setId(1); user.setName("mahesh"); user.setExperience(15);
	 * user.setAddress("Bangalore"); user.setDesignation("manager");
	 * user.setMobileno(98L); Optional<User> use =Optional.of(new User());
	 * BeanUtils.copyProperties(user, use); Request re = new Request();
	 * Mockito.when(userRepo.findById(Mockito.anyInt())).thenReturn(use);
	 * Mockito.when(requestRepo.save(Mockito.any())).thenReturn(Mockito.doNothing())
	 * ; String s=userService.sendRequest(1);
	 * assertEquals("your request send successfully", s); }
	 */

	@Test
	public void testReleaseSlot() {
		UserDto user = new UserDto();
		user.setId(1);
		user.setName("mahesh");
		user.setExperience(15);
		user.setAddress("Bangalore");
		user.setDesignation("manager");
		user.setMobileno(98L);
		User use = new User();
		BeanUtils.copyProperties(user, use);
		ParkingSlot ps = new ParkingSlot();
		ps.setDays(3);
		ps.setUser(use);
		Mockito.when(parkingSlotRepo.findByUserId(Mockito.anyInt())).thenReturn(ps);
		String s = userService.releaseSlot(use.getId(), ps.getDays());
		assertEquals("your slot released successfully", s);
	}

}
