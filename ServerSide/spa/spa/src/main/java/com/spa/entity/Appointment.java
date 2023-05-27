package com.spa.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private List<Therepy> therepies;

	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private List<Therapist> therapists;

	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private Room room;
	
	

	public Appointment() {
		super();
	}

	public Appointment(Long id, List<Therepy> therepies, List<Therapist> therapists, Room room) {
		super();
		this.id = id;
		this.therepies = therepies;
		this.therapists = therapists;
		this.room = room;
	}

	/**
	 
	 {
	 	"therepieNames" : ["Gold"],
	 	
	 	"therapistNames": ["abc"],
	 	
	 	"roomNo": 101
	 
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Therepy> getTherepies() {
		return therepies;
	}

	public void setTherepies(List<Therepy> therepies) {
		this.therepies = therepies;
	}

	public List<Therapist> getTherapists() {
		return therapists;
	}

	public void setTherapists(List<Therapist> therapists) {
		this.therapists = therapists;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
