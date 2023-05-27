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
public class Therepy {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String name;
	private double price;
	private int duration;
	private String discription;
	private String benifit;
	
	
	/**
	 {
    "name": "Gold",
    "price": 13,
    "duration": 50,
    "discription": "this is discription good",
    "benifit": "this is benifit"
    // "equipments": [
    //     {
    //         "name": "Massage Table",
    //         "quantity": 2
    //     },
    //     {
    //         "name": "Facial Bed",
    //         "quantity": 1
    //     }
    // ]
}
	 
	 */
	
	public Therepy() {
		super();
	}

	public Therepy(long id, String name, double price, int duration, String discription, String benifit,
			List<Equipment> equipments) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.duration = duration;
		this.discription = discription;
		this.benifit = benifit;
		this.equipments = equipments;
	}

	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private List<Equipment> equipments;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getBenifit() {
		return benifit;
	}

	public void setBenifit(String benifit) {
		this.benifit = benifit;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	
	
	
	
}
