package com.fiap.aoj.nexflix.titulo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/titulos") 
@Api(value = "API REST Titulos Netflix")
@CrossOrigin(origins = "*")
public class TituloController {
	
	@Autowired
	private TituloService service;
	
	@GetMapping("/porGenero/{genero}")
	@ApiOperation(value = "Busca de Título por Gênero")
	public List<Object> findByGenero(@PathVariable String genero){
		return service.getTitulosPorGenero(genero);
	}

	@GetMapping("/detalhes")
	@ApiOperation(value = "Busca detalhes de todos os Títulos")
	public List<Object> getDetalhes(){
		return service.getDetalhesTitulo();
	}
	
	@GetMapping("/qtdTitulosPorGenero")
	@ApiOperation(value = "Busca quantidade de Títulos por Gênero")
	public List<Object> getTitulosPorGenero(){
		return service.getTitulosPorGenero();
	}
	
	@PostMapping("/verAssistidos")
	@ApiOperation(value = "Ver Títulos Assistidos")
	public List<Object> verTitulosAssistidos(@RequestBody TituloAssistido tituloAssistido){
		tituloAssistido.setTipo(1); // ASSISTIDO
		return service.getTitulosAssistidos(tituloAssistido);
	}
	
	@GetMapping("/porPalavraChave/{palavraChave}")
	@ApiOperation(value = "Busca de Título por Palavra-Chave")
	public List<Object> findByPalavraChave(@PathVariable String palavraChave){
		return service.getTitulosPorPalavraChave(palavraChave);
	}
	
	@GetMapping("/porCategoria/{categoria}")
	@ApiOperation(value = "Busca de Título por Categoria")
	public List<Object> findByCategoria(@PathVariable String categoria){
		return service.getTitulosPorCategoria(categoria);
	}
	
	@GetMapping("/maisAssistidosGenero/{genero}")
	@ApiOperation(value = "Ver Títulos mais assistidos por Gênero")
	public List<Object> findMaisAssistidosGenero(@PathVariable String genero){
		return service.getTitulosMaisAssistidosPorGenero(genero);
	}

	@GetMapping("/dataHora")
	@ApiOperation(value = "Busca Data e Hora Local")
	public List<Object> getDataHora(){
		return service.getDataHora();
	}
	
	@PostMapping("/votar")
	@ApiOperation(value = "Votar em um Título")
	public String votarTitulo(@RequestBody Votacao votacao) {
		return service.votarTitulo(votacao);
	}
	
	@PostMapping("/marcarAssistido")
	@ApiOperation(value = "Marcar Título como Assistido")
	public String marcarAssistido(@RequestBody MarcarTitulo marcarTitulo) {
		marcarTitulo.setAssistidoVerNoFuturo(1); // ASSISTIDO
		return service.marcarTituloComoAssistido(marcarTitulo);
	}
	
	@PostMapping("/marcarVerFuturo")
	@ApiOperation(value = "Marcar Título para ver no futuro")
	public String marcarVerNoFuturo(@RequestBody MarcarTitulo marcarTitulo) {
		marcarTitulo.setAssistidoVerNoFuturo(2); // VER NO FUTURO
		return service.marcarTituloComoAssistido(marcarTitulo);
	}
	
	
}
