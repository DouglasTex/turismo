package com.estudo.turismo.serviceimp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.turismo.model.Atrativo;
import com.estudo.turismo.repository.TurismoRepository;
import com.estudo.turismo.service.TurismoService;

@Service
public class TurismoServiceImp implements TurismoService {

	@Autowired
	TurismoRepository turismoRepository;
	
	@Override
	public List<Atrativo> findAll() {
		return turismoRepository.findAll();
	}

	@Override
	public Atrativo findById(long id) {
		return turismoRepository.findById(id).get();
	}

	@Override
	public Atrativo save(Atrativo atrativo) {
		return turismoRepository.save(atrativo);
	}

	@Override
	public List<Atrativo> findByTipo(String tipo) {
		return turismoRepository.findByTipo(tipo);
	}

	@Override
	public void delete(Atrativo atrativo) {
		turismoRepository.delete(atrativo);
	}

	
}
