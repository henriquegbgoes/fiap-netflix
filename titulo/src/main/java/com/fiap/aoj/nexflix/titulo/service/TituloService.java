package com.fiap.aoj.nexflix.titulo.service;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

import com.fiap.aoj.nexflix.titulo.entity.Titulo;

@Service
public class TituloService {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Titulo> getTitulosPorGenero(String genero) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_titulo_genero");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.setParameter(1, genero);
		query.execute();
		return query.getResultList();
	}

	public List<Titulo> getDetalhesTitulo() {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_titulo_detalhes");
		query.execute();
		return query.getResultList();
	}

	public String getDataHora() {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_dataHora");
		query.execute();
		Timestamp outMessage = (Timestamp) query.getSingleResult();
		return outMessage.toString();
	}

}
