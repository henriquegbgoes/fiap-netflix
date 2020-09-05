package com.fiap.aoj.nexflix.titulo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "tb_titulo")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
    		name = "getTituloByGenero",  
    		procedureName = "sp_titulo_genero", 
    		resultClasses = Titulo.class,
    		parameters = { @StoredProcedureParameter(name = "in_genero", type = String.class, mode = ParameterMode.IN) }
    ),
    @NamedStoredProcedureQuery(
    		name = "getTituloDetalhes",  
    		procedureName = "sp_titulo_detalhes",
    		resultClasses = Titulo.class
    )
})
public class Titulo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idTitulo;
	private Character tipo;
	private String nome;
	private String resumo;
	private String atores;
	private Integer classificacaoEtaria;
	private String ano;
	private String palavraChave;
	private Integer temporada;

	public Character getTipo() {
		return tipo;
	}
	public String getNome() {
		return nome;
	}
	public String getResumo() {
		return resumo;
	}
	public String getAtores() {
		return atores;
	}
	public Integer getClassificacaoEtaria() {
		return classificacaoEtaria;
	}
	public String getAno() {
		return ano;
	}
	public String getPalavraChave() {
		return palavraChave;
	}
	public Integer getTemporada() {
		return temporada;
	}
	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public void setAtores(String atores) {
		this.atores = atores;
	}
	public void setClassificacaoEtaria(Integer classificacaoEtaria) {
		this.classificacaoEtaria = classificacaoEtaria;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}
	public void setTemporada(Integer temporada) {
		this.temporada = temporada;
	}
	public Integer getIdTitulo() {
		return idTitulo;
	}
	public void setIdTitulo(Integer idTitulo) {
		this.idTitulo = idTitulo;
	}
}
