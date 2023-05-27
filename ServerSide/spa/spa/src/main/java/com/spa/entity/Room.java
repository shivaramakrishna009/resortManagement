package com.spa.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Integer roomNo;

	private Integer size;

	private String roomType;

	private Boolean AirConditioner;

	private Integer capacity;

	private String privacy;

	private Boolean available;

	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private List<Equipment> equipments;

	/**
	 * { "roomNo": 101, "size": 200, "roomType": "Standard", "airConditioner": true,
	 * "capacity": 2, "privacy": "Private", "available": true, "equipments": [ {
	 * "name": "Massage Table", "quantity": 2 }, { "name": "Facial Bed", "quantity":
	 * 1 } ] }
	 * 
	 */
	public Room() {
	}

	public Room(Long id, Integer roomNo, Integer size, String roomType, Boolean airConditioner, Integer capacity,
			String privacy, Boolean available, List<Equipment> equipments) {
		super();
		this.id = id;
		this.roomNo = roomNo;
		this.size = size;
		this.roomType = roomType;
		AirConditioner = airConditioner;
		this.capacity = capacity;
		this.privacy = privacy;
		this.available = available;
		this.equipments = equipments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(unique = true)
	public Integer getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Boolean getAirConditioner() {
		return AirConditioner;
	}

	public void setAirConditioner(Boolean airConditioner) {
		AirConditioner = airConditioner;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public Boolean isAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

}
