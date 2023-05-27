package com.spa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spa.entity.Room;
import com.spa.service.RoomService;

@RestController
@RequestMapping("api/v1/room")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@PostMapping
	public ResponseEntity<Room> Add(@RequestBody Room room) {
		return roomService.addRoom(room);
	}

	@PutMapping
	public ResponseEntity<Room> update(@PathVariable Long id, @RequestBody Room room) {
		return roomService.update(id,room);
	}

	@GetMapping
	public ResponseEntity<List<Room>> findAll() {
		return roomService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Room> GetById(@PathVariable Long id) {
		return roomService.findById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Room> DeleteById(@PathVariable Long id) {
		return roomService.deleteById(id);
	}
}
