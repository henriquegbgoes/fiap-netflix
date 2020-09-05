package com.fiap.aoj.nexflix.titulo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.aoj.nexflix.titulo.entity.Titulo;
import com.fiap.aoj.nexflix.titulo.service.TituloService;

@RestController
@RequestMapping("/titulos") 
public class TituloController {
	
	@Autowired
	private TituloService service;
	
	@GetMapping("/porGenero/{genero}")
	public List<Titulo> findByGenero(@PathVariable String genero){
		return service.getTitulosPorGenero(genero);
	}
	
	@GetMapping("/detalhes")
	public List<Titulo> getDetalhes(){
		return service.getDetalhesTitulo();
	}

	@GetMapping("/dataHora")
	public String getDataHora(){
		return service.getDataHora();
	}
}
