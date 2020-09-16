package com.fiap.aoj.nexflix.suporte.model;

public class Suporte {

	private Integer idUsuario;
	private Integer idTitulo;
	private Integer tipoProblema;
	private Integer tipoDispositivo;
	private String nomeDispositivo;
	private String descricao;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public Integer getIdTitulo() {
		return idTitulo;
	}
	public Integer getTipoProblema() {
		return tipoProblema;
	}
	public Integer getTipoDispositivo() {
		return tipoDispositivo;
	}
	public String getNomeDispositivo() {
		return nomeDispositivo;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public void setIdTitulo(Integer idTitulo) {
		this.idTitulo = idTitulo;
	}
	public void setTipoProblema(Integer tipoProblema) {
		this.tipoProblema = tipoProblema;
	}
	public void setTipoDispositivo(Integer tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}
	public void setNomeDispositivo(String nomeDispositivo) {
		this.nomeDispositivo = nomeDispositivo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
