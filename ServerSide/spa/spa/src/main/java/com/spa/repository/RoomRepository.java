package com.spa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spa.entity.Appointment;
import com.spa.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

	Room findByRoomNo(Long roomNo);
}
