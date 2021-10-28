package com.estudo.turismo.service;

import java.util.List;

import com.estudo.turismo.model.Atrativo;

public interface TurismoService {
	
	List<Atrativo> findAll();
	Atrativo findById(long id);
	Atrativo save(Atrativo atrativo);
	List<Atrativo> findByTipo(String tipo);
	void delete(Atrativo atrativo);

}
