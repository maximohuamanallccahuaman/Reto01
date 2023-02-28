package com.reto.Reto01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reto.Reto01.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
