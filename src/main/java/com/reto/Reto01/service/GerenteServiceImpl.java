package com.reto.Reto01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reto.Reto01.model.Gerente;
import com.reto.Reto01.repository.GerenteRepository;

@Service
public class GerenteServiceImpl implements IGerenteService {

	@Autowired
	private GerenteRepository gerenteRepo;
	
	@Override
	public void guardar(Gerente gerente) {
		gerenteRepo.save(gerente);

	}

	@Override
	public List<Gerente> buscarTodas() {
		return gerenteRepo.findAll();
	}

	@Override
	public Gerente buscarPorId(Integer IDGERENTE) {
		Optional<Gerente> optional = gerenteRepo.findById(IDGERENTE);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer IDGERENTE) {
		gerenteRepo.deleteById(IDGERENTE);

	}

	@Override
	public Page<Gerente> buscarTodas(Pageable page) {
		return gerenteRepo.findAll(page);
	}

}
