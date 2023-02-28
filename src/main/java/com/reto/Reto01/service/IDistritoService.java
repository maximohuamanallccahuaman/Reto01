package com.reto.Reto01.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.reto.Reto01.model.Condicion;
import com.reto.Reto01.model.Distrito;

public interface IDistritoService {

	void guardar(Distrito distrito);
	List<Distrito> buscarTodas();
	Distrito buscarPorId(Integer IDDISTRITO);		
	void eliminar(Integer IDDISTRITO);
	Page<Distrito> buscarTodas(Pageable page);
}
