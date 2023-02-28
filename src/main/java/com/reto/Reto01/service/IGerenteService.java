package com.reto.Reto01.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.reto.Reto01.model.Gerente;
import com.reto.Reto01.model.Sede;

public interface IGerenteService {
	
	void guardar(Gerente gerente);
	List<Gerente> buscarTodas();
	Gerente buscarPorId(Integer IDGERENTE);		
	void eliminar(Integer IDGERENTE);
	Page<Gerente> buscarTodas(Pageable page);

}
