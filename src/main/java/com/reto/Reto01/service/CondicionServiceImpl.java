package com.reto.Reto01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reto.Reto01.model.Condicion;
import com.reto.Reto01.repository.CondicionRepository;

@Service
public class CondicionServiceImpl implements ICondicionService {

	@Autowired
	private CondicionRepository condicionRepo;
	
	@Override
	public void guardar(Condicion condicion) {
		condicionRepo.save(condicion);

	}

	@Override
	public List<Condicion> buscarTodas() {
		return condicionRepo.findAll();
	}

	@Override
	public Condicion buscarPorId(Integer IDCONDICION) {
		Optional<Condicion> optional = condicionRepo.findById(IDCONDICION);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer IDCONDICION) {
		condicionRepo.deleteById(IDCONDICION);

	}

	@Override
	public Page<Condicion> buscarTodas(Pageable page) {
		return condicionRepo.findAll(page);
	}

}
