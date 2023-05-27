package com.spa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Therapist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	private String gender;
	private String specialization;
	private int experience;
	private String languages;
	private String emailId;
	private long mobile;
	private String profilePic;

	/**
	 {
	"name": "abc",
	"gender": "male",
	"specialization": "massage therapy",
	"experience": 2,
	"languages": "english",
	"emailId": "abc@gmail.com",
	"mobile": "9552905109"
}
	 
	 */
	
	public Therapist() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

//	public Therapist(Long id, String name, String gender, String specialization, int experience, String languages,
//			String emailId, long mobile, String profilePic) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.gender = gender;
//		this.specialization = specialization;
//		this.experience = experience;
//		this.languages = languages;
//		this.emailId = emailId;
//		this.mobile = mobile;
//		this.profilePic = profilePic;
//	}

}

//private Long id;
//private String Name;
//private String gender;
//private String specialization;
//private int experience;
//private String languages;
//private String emailId;
//private long mobile;
//private String profilePic;

