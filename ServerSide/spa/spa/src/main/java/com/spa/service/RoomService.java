package com.spa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spa.entity.Room;
import com.spa.repository.RoomRepository;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;

	public ResponseEntity<Room> addRoom(Room room) {
		Room room1 = roomRepository.save(room);
		return ResponseEntity.ok(room1);
	}

	public ResponseEntity<Room> update(Room room) {
		Room room1 = roomRepository.findById(room.getId()).get();
		room1.setAirConditioner(room.getAirConditioner());
		room1.setAvailable(room.isAvailable());
		room1.setCapacity(room.getCapacity());
		room1.setEquipments(room.getEquipments());
		room1.setPrivacy(room.getPrivacy());
		room1.setRoomNo(room.getRoomNo());
		room1.setRoomType(room.getRoomType());
		room1.setSize(room.getSize());

		room1 = roomRepository.save(room1);
		return ResponseEntity.ok(room1);
	}

	public ResponseEntity<Room> deleteById(Long id) {
		Room room = roomRepository.findById(id).get();
		roomRepository.deleteById(id);
		return ResponseEntity.ok(room);
	}

	public ResponseEntity<Room> findById(Long id) {
		Room room = roomRepository.findById(id).get();
		return ResponseEntity.ok(room);

	}

	public ResponseEntity<List<Room>> findAll() {
		List<Room> list = new ArrayList<>();
		list = roomRepository.findAll();
		return ResponseEntity.ok(list);
	}
}
