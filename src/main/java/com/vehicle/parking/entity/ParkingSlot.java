package com.vehicle.parking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ParkingSlot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int SlotId;
	
	private int status;
	
	private String floor;
	
	@Column(columnDefinition = "int default 0")
	private int days;
	
	@OneToOne
	User user;

	public int getSlotId() {
		return SlotId;
	}

	public void setSlotId(int slotId) {
		SlotId = slotId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
