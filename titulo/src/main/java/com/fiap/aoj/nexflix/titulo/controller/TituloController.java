package com.fiap.aoj.nexflix.titulo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.aoj.nexflix.titulo.dto.MarcarTitulo;
import com.fiap.aoj.nexflix.titulo.dto.TituloAssistido;
import com.fiap.aoj.nexflix.titulo.dto.Votacao;
import com.fiap.aoj.nexflix.titulo.service.TituloService;

@RestController
@RequestMapping("/titulos") 
public class TituloController {
	
	@Autowired
	private TituloService service;
	
	@GetMapping("/porGenero/{genero}")
	public List<Object> findByGenero(@PathVariable String genero){
		return service.getTitulosPorGenero(genero);
	}

	@GetMapping("/detalhes")
	public List<Object> getDetalhes(){
		return service.getDetalhesTitulo();
	}
	
	@GetMapping("/qtdTitulosPorGenero")
	public List<Object> getTitulosPorGenero(){
		return service.getTitulosPorGenero();
	}
	
	@PostMapping("/verAssistidos")
	public List<Object> verTitulosAssistidos(@RequestBody TituloAssistido tituloAssistido){
		tituloAssistido.setTipo(1); // ASSISTIDO
		return service.getTitulosAssistidos(tituloAssistido);
	}
	
	@GetMapping("/porPalavraChave/{palavraChave}")
	public List<Object> findByPalavraChave(@PathVariable String palavraChave){
		return service.getTitulosPorPalavraChave(palavraChave);
	}
	
	@GetMapping("/porCategoria/{categoria}")
	public List<Object> findByCategoria(@PathVariable String categoria){
		return service.getTitulosPorCategoria(categoria);
	}
	
	@GetMapping("/maisAssistidosGenero/{genero}")
	public List<Object> findMaisAssistidosGenero(@PathVariable String genero){
		return service.getTitulosMaisAssistidosPorGenero(genero);
	}

	@GetMapping("/dataHora")
	public List<Object> getDataHora(){
		return service.getDataHora();
	}
	
	@PostMapping("/votar")
	public String votarTitulo(@RequestBody Votacao votacao) {
		return service.votarTitulo(votacao);
	}
	
	@PostMapping("/marcarAssistido")
	public String marcarAssistido(@RequestBody MarcarTitulo marcarTitulo) {
		marcarTitulo.setAssistidoVerNoFuturo(1); // ASSISTIDO
		return service.marcarTituloComoAssistido(marcarTitulo);
	}
	
	@PostMapping("/marcarVerFuturo")
	public String marcarVerNoFuturo(@RequestBody MarcarTitulo marcarTitulo) {
		marcarTitulo.setAssistidoVerNoFuturo(2); // VER NO FUTURO
		return service.marcarTituloComoAssistido(marcarTitulo);
	}
	
	
}
