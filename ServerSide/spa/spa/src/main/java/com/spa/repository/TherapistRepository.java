package com.spa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spa.entity.Therapist;

@Repository
public interface TherapistRepository extends JpaRepository<Therapist, Long> {
	public Therapist findByName(String name);
}
