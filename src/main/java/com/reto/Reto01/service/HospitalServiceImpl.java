package com.reto.Reto01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reto.Reto01.model.Distrito;
import com.reto.Reto01.model.Hospital;
import com.reto.Reto01.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements IHospitalService{

	@Autowired
	private HospitalRepository hospitalRepo;

	@Override
	public void guardar(Hospital hospital) {
		hospitalRepo.save(hospital);
	}

	@Override
	public List<Hospital> buscarTodas() {
		return hospitalRepo.findAll();
	}

	@Override
	public Hospital buscarPorId(Integer IDHOSPITAL) {
		Optional<Hospital> optional = hospitalRepo.findById(IDHOSPITAL);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer IDHOSPITAL) {
		hospitalRepo.deleteById(IDHOSPITAL);
		
	}

	@Override
	public Page<Hospital> buscarTodas(Pageable page) {
		return hospitalRepo.findAll(page);
	}

	
	
}
