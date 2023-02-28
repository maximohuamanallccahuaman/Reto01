package com.reto.Reto01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reto.Reto01.model.Sede;
import com.reto.Reto01.repository.SedeRepository;

@Service
public class SedeServiceImpl implements ISedeService {

	@Autowired
	private SedeRepository sedeRepo;
	
	@Override
	public void guardar(Sede sede) {
		sedeRepo.save(sede);

	}

	@Override
	public List<Sede> buscarTodas() {
		return sedeRepo.findAll();
	}

	@Override
	public Sede buscarPorId(Integer IDSEDE) {
		Optional<Sede> optional = sedeRepo.findById(IDSEDE);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer IDSEDE) {
		sedeRepo.deleteById(IDSEDE);

	}

	@Override
	public Page<Sede> buscarTodas(Pageable page) {
		return sedeRepo.findAll(page);
	}

}
