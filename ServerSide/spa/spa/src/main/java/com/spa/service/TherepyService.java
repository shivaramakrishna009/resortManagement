package com.spa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spa.entity.Therepy;
import com.spa.exception.ResourceNotFoundException;
import com.spa.repository.TherepyRepository;

@Service

public class TherepyService {

	@Autowired
	private TherepyRepository therepyRepository;
	
	public ResponseEntity<Therepy> addTherapy(Therepy therepy) {
	   therepyRepository.save(therepy);
	    return ResponseEntity.ok(therepy);
	}
	public ResponseEntity<List<Therepy>> allTherepy() {
		List<Therepy> therepy =   therepyRepository.findAll();
		    return ResponseEntity.ok(therepy);
		}
	

	public ResponseEntity<Therepy> updateTherapy(long id,Therepy therepy) {
	    Therepy existingTherepy = therepyRepository.findById(id).orElseThrow(() ->
	            new ResourceNotFoundException("Therepy not found with ID: " + id));
	    existingTherepy.setName(therepy.getName());
	    existingTherepy.setPrice(therepy.getPrice());
	    existingTherepy.setDuration(therepy.getDuration());
	    existingTherepy.setBenifit(therepy.getBenifit());
	    existingTherepy.setDiscription(therepy.getDiscription());
	    existingTherepy.setEquipments(therepy.getEquipments());
	    Therepy updatedTherepy = therepyRepository.save(existingTherepy);
	    return ResponseEntity.ok(updatedTherepy);
	}

	public ResponseEntity<Therepy> deleteTherapyById(Long id) {
	    Therepy therepy = therepyRepository.findById(id).orElseThrow(() ->
	            new ResourceNotFoundException("Therepy not found with ID: " + id));

	    therepyRepository.deleteById(id);
	    return ResponseEntity.ok(therepy);
	}

	public ResponseEntity<Therepy> findTherapyById(Long id) {
	    Therepy therapy = therepyRepository.findById(id).orElseThrow(() ->
	            new ResourceNotFoundException("Therepy not found with ID: " + id));

	    return ResponseEntity.ok(therapy);
	}

	
}
