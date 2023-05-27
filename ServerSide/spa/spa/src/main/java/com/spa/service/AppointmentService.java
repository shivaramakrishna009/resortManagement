package com.spa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spa.entity.Appointment;
import com.spa.entity.Room;
import com.spa.entity.Therapist;
import com.spa.entity.Therepy;
import com.spa.exception.ResourceNotFoundException;
import com.spa.repository.AppointmentRepository;
import com.spa.repository.RoomRepository;
import com.spa.repository.TherapistRepository;
import com.spa.repository.TherepyRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private TherepyRepository therepyRepository;

	@Autowired
	private TherapistRepository therapistRepository;

	@Autowired
	private RoomRepository roomRepository;

	public ResponseEntity<Appointment> save(List<String> therepieNames, List<String> therapistNames, Long roomNo) {

		List<Therepy> therepies = new ArrayList<>();
		List<Therapist> therapists = new ArrayList<>();

		for (String name : therepieNames) {
			System.out.println(name);
			therepies.add(therepyRepository.findByName(name));
			
		}
		
		for (String name : therapistNames) {
			therapists.add(therapistRepository.findByName(name));
		}

		System.out.println(therapists);
		System.out.println(therepies);
		Room room = roomRepository.findByRoomNo(roomNo);
		
		Appointment appointment = new Appointment();
		appointment.setTherapists(therapists);
		appointment.setTherepies(therepies);
		appointment.setRoom(room);
		
		appointment = appointmentRepository.save(appointment);
		return ResponseEntity.ok(appointment);
	}

	public ResponseEntity<List<Appointment>> findAll() {
		List<Appointment> appointments = appointmentRepository.findAll();
		return ResponseEntity.ok(appointments);
	}

	public ResponseEntity<Appointment> findById(Long id) {
		Appointment appointment = appointmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment with " + id + " is not available"));
		return ResponseEntity.ok(appointment);
	}

	public ResponseEntity<Appointment> update(Long id, Appointment appointmentDetails) {
		Appointment appointment = appointmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment with " + id + " is not available"));
		appointment.setTherapists(appointmentDetails.getTherapists());
		appointment.setTherepies(appointmentDetails.getTherepies());
		appointment.setRoom(appointmentDetails.getRoom());
		return ResponseEntity.ok(appointment);
	}

	public ResponseEntity<Map<String, Boolean>> delete(Long id) {
		Appointment appointment = appointmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment with " + id + " is not available"));
		appointmentRepository.delete(appointment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
