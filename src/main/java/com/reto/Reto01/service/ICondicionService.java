package com.reto.Reto01.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.reto.Reto01.model.Condicion;
import com.reto.Reto01.model.Provincia;

public interface ICondicionService {
	
	void guardar(Condicion condicion);
	List<Condicion> buscarTodas();
	Condicion buscarPorId(Integer IDCONDICION);		
	void eliminar(Integer IDCONDICION);
	Page<Condicion> buscarTodas(Pageable page);

}
