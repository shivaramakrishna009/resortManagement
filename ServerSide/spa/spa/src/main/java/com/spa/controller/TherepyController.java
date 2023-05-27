package com.spa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spa.entity.Therepy;
import com.spa.service.TherepyService;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class TherepyController {
		
		@Autowired
		private TherepyService therepyService;
		
		@PostMapping("/therepy")
		public ResponseEntity<Therepy> addTherapy(@RequestBody Therepy therepy) {
		   
		    return therepyService.addTherapy(therepy);
		}
		@GetMapping("/therepy")
		public ResponseEntity<List<Therepy>> allTherepy() {
			
			    return therepyService.allTherepy();
			}
		

		@PutMapping("/therepy/{id}")
		public ResponseEntity<Therepy> updateTherapy(@PathVariable Long id,@RequestBody Therepy therepy) {
		    return therepyService.updateTherapy(id, therepy);
		    
		}
		@DeleteMapping("/therepy/{id}")
		public ResponseEntity<Therepy> deleteTherapyById(@PathVariable Long id) {
		   return therepyService.deleteTherapyById(id);
		}
		@GetMapping("/therepy/{id}")
		public ResponseEntity<Therepy> findTherapyById(@PathVariable Long id) {
			return therepyService.findTherapyById(id);
		}
}
