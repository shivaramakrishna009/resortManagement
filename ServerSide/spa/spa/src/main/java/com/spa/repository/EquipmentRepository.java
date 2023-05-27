package com.spa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spa.entity.Equipment;

@Repository 
public interface EquipmentRepository extends JpaRepository<Equipment, Long>{

}
