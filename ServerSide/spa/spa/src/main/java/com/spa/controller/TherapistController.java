package com.spa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spa.entity.Therapist;
import com.spa.service.TherapistService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/")
public class TherapistController {
	
	@Autowired
	private TherapistService therapistService;
	
    @PostMapping("therapist")
    public ResponseEntity<Therapist> saveTherapist(@RequestParam("profilePic") MultipartFile profilePic,
                                                  @RequestParam("therapist") String therapistJson) throws Exception {
        return therapistService.saveTherapist(profilePic, therapistJson);
    }
        
}
