package com.estudo.turismo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.estudo.turismo.model.Atrativo;

public interface TurismoRepository extends JpaRepository<Atrativo, Long> {
	
	List<Atrativo> findByTipo(String tipo);
	
	@Query("select a from Atrativo a where a.nome like %?1%")
	List<Atrativo> findByNome(String nome);
	
}
