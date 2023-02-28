package com.reto.Reto01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reto.Reto01.model.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {

}
