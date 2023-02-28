package com.reto.Reto01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reto.Reto01.model.Hospital;
import com.reto.Reto01.model.Provincia;
import com.reto.Reto01.repository.ProvinciaRepository;

@Service
public class ProvinciaServiceImpl implements IProvinciaService{
	
	@Autowired
	private ProvinciaRepository provinciaRepo;
	
	@Override
	public void guardar(Provincia provincia) {
		provinciaRepo.save(provincia);
		
	}

	@Override
	public List<Provincia> buscarTodas() {
		return provinciaRepo.findAll();
	}

	@Override
	public Provincia buscarPorId(Integer IDPROVINCIA) {
		Optional<Provincia> optional = provinciaRepo.findById(IDPROVINCIA);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer IDPROVINCIA) {
		provinciaRepo.deleteById(IDPROVINCIA);
		
	}

	@Override
	public Page<Provincia> buscarTodas(Pageable page) {
		return provinciaRepo.findAll(page);
	}
}
