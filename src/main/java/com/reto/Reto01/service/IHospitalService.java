package com.reto.Reto01.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.reto.Reto01.model.Distrito;
import com.reto.Reto01.model.Hospital;

public interface IHospitalService {
	
	void guardar(Hospital hospital);
	List<Hospital> buscarTodas();
	Hospital buscarPorId(Integer IDHOSPITAL);		
	void eliminar(Integer IDHOSPITAL);
	Page<Hospital> buscarTodas(Pageable page);

}
