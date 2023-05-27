package com.spa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spa.entity.Therepy;

@Repository
public interface TherepyRepository extends JpaRepository<Therepy, Long>  {
	public Therepy findByName(String name);
}
