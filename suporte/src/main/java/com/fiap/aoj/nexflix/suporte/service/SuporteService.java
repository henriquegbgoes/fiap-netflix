package com.fiap.aoj.nexflix.suporte.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fiap.aoj.nexflix.suporte.dto.Suporte;
import com.fiap.aoj.nexflix.suporte.repository.DBRepository;

@Service
public class SuporteService {

	@Value("${sensibilizaInsert}")
	private boolean SENSIBILIZA_INSERT;
	
	@Autowired
	private DBRepository dbRepository;
	
	public String abrirChamado(Suporte suporte) {
		List<Object> result;
		if(!SENSIBILIZA_INSERT) 
			result = Arrays.asList(Boolean.TRUE);
		else 
			result = dbRepository.callProcedure(suporte, "sp_incluir_suporte");
		
		if(result.contains(Boolean.TRUE))
			return "Chamado Aberto com sucesso!!!";
		else 
			return "Não foi possível abrir o chamado!!!";
	}
}
