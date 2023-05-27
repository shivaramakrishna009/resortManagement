package com.spa.service;

import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spa.entity.Therapist;
import com.spa.repository.TherapistRepository;

@Service
public class TherapistService {
	
	@Autowired
	private TherapistRepository therapistRepository;
	
	
    public ResponseEntity<Therapist> saveTherapist(MultipartFile profilePic, String therapistJson) throws Exception {
        Therapist therapist = new ObjectMapper().readValue(therapistJson, Therapist.class);

        if (profilePic != null) {
            String fileName = therapist.getName() + profilePic.getOriginalFilename()
                    .substring(profilePic.getOriginalFilename().lastIndexOf('.'));
            FileOutputStream fout = new FileOutputStream(
                    "C:\\file-handling\\" + fileName);
            fout.write(profilePic.getBytes());
            therapist.setProfilePic(fileName);
        }

        Therapist savedTherapist = therapistRepository.save(therapist);
        return ResponseEntity.ok(savedTherapist);
    }
    
    

    
}
