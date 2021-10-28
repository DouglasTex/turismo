package com.estudo.turismo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.turismo.model.Atrativo;

public interface TurismoRepository extends JpaRepository<Atrativo, Long> {
	
	List<Atrativo> findByTipo(String tipo);
}
