package com.reto.Reto01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reto.Reto01.model.Distrito;
import com.reto.Reto01.repository.DistritoRepository;

@Service
public class DistritoServiceImpl implements IDistritoService {

	@Autowired
	private DistritoRepository distritoRepo;
	
	@Override
	public void guardar(Distrito distrito) {
		distritoRepo.save(distrito);

	}

	@Override
	public List<Distrito> buscarTodas() {
		return distritoRepo.findAll();
	}

	@Override
	public Distrito buscarPorId(Integer IDDISTRITO) {
		Optional<Distrito> optional = distritoRepo.findById(IDDISTRITO);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer IDDISTRITO) {
		distritoRepo.deleteById(IDDISTRITO);

	}

	@Override
	public Page<Distrito> buscarTodas(Pageable page) {
		return distritoRepo.findAll(page);
	}

}
