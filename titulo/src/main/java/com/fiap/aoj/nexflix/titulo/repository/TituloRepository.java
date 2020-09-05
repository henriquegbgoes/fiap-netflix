package com.fiap.aoj.nexflix.titulo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.fiap.aoj.nexflix.titulo.entity.Titulo;

@Repository	
public interface TituloRepository extends JpaRepository<Titulo, Integer>  {

	@Procedure(name = "getTituloByGenero")
	List<Titulo> getTitulosPorGenero(String in_genero);
	
	@Procedure(name = "getTituloDetalhes")
	List<Titulo> getDetalhesTitulo();
	
}
