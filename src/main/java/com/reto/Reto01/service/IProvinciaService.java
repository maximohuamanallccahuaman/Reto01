package com.reto.Reto01.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reto.Reto01.model.Hospital;
import com.reto.Reto01.model.Provincia;

@Service
public interface IProvinciaService {

	void guardar(Provincia provincia);
	List<Provincia> buscarTodas();
	Provincia buscarPorId(Integer IDPROVINCIA);		
	void eliminar(Integer IDPROVINCIA);
	Page<Provincia> buscarTodas(Pageable page);

}
