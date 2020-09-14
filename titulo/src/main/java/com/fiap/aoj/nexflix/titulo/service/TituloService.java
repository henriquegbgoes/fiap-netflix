package com.fiap.aoj.nexflix.titulo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fiap.aoj.nexflix.titulo.dto.MarcarTitulo;
import com.fiap.aoj.nexflix.titulo.dto.TituloAssistido;
import com.fiap.aoj.nexflix.titulo.dto.Votacao;
import com.fiap.aoj.nexflix.titulo.repository.DBRepository;

@Service
public class TituloService {

	@Value("${sensibilizaInsert}")
	private boolean SENSIBILIZA_INSERT;
	
	@Autowired
	private DBRepository dbRepository;

	public List<Object> getTitulosPorGenero(String genero) {
		return dbRepository.callProcedure(genero, "sp_titulo_genero");
	}

	public List<Object> getDetalhesTitulo() {
		return dbRepository.callProcedure(null, "sp_titulo_detalhes");
	}
	
	public List<Object> getTitulosPorGenero() {
		return dbRepository.callProcedure(null, "sp_qtdtitulos_genero");
	}
	
	public List<Object> getTitulosAssistidos(TituloAssistido tituloAssistido) {
		return dbRepository.callProcedure(tituloAssistido, "sp_titulo_assistido");
	}
	
	public List<Object> getTitulosPorPalavraChave(String palavrachave) {
		return dbRepository.callProcedure(palavrachave, "sp_titulo_palavrachave");
	}
	
	public List<Object> getTitulosMaisAssistidosPorGenero(String genero) {
		return dbRepository.callProcedure(genero, "sp_maisassistidos_genero");
	}

	public List<Object> getDataHora() {
		return dbRepository.callProcedure(null, "sp_dataHora");
	}
	
	public String votarTitulo(Votacao votacao) {
		
		List<Object> result;
		if(!SENSIBILIZA_INSERT) 
			result = Arrays.asList(Boolean.TRUE);
		else 
			result = dbRepository.callProcedure(votacao, "sp_incluir_titulo_votacao");
		
		if(result.contains(Boolean.TRUE))
			return "Votação incluída com sucesso";
		else 
			return "Não foi possível incluir Votação";
	}
	
	public String marcarTituloComoAssistido(MarcarTitulo marcarTitulo) {
		List<Object> result = dbRepository.callProcedure(marcarTitulo, "sp_incluir_titulo_assistido");
		if(result.contains(Boolean.TRUE))
			return marcarTitulo.getAssistidoVerNoFuturo() == 1 ? "Título marcado como Assistido com sucesso" : "Título marcado para ver no futuro";
		else 
			return marcarTitulo.getAssistidoVerNoFuturo() == 1 ? "Não foi possível marcar o Título como Assistido" : "Não foi possível marcar para ver no futuro";
	}

	public List<Object> getTitulosPorCategoria(String categoria) {
		return dbRepository.callProcedure(categoria, "sp_maisassistidos_genero");
	}
	
}
