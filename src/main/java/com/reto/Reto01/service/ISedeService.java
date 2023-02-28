package com.reto.Reto01.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.reto.Reto01.model.Provincia;
import com.reto.Reto01.model.Sede;

public interface ISedeService {

	void guardar(Sede sede);
	List<Sede> buscarTodas();
	Sede buscarPorId(Integer IDSEDE);		
	void eliminar(Integer IDSEDE);
	Page<Sede> buscarTodas(Pageable page);
}
