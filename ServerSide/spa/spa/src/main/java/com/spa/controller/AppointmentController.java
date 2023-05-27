package com.spa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spa.entity.Appointment;
import com.spa.service.AppointmentService;

@RestController
@RequestMapping("api/v1/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@PostMapping
	public ResponseEntity<Appointment> save(@RequestParam("therepieNames") List<String> therepieNames,
			@RequestParam("therapistNames") List<String> therapistNames, @RequestParam("roomNo") Long roomNo) {
		return appointmentService.save(therepieNames, therapistNames, roomNo);
	}

	@GetMapping
	public ResponseEntity<List<Appointment>> findAll() {
		return appointmentService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Appointment> findById(@PathVariable Long id) {
		return appointmentService.findById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody Appointment appointment) {
		return appointmentService.update(id, appointment);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
		return appointmentService.delete(id);
	}
}
