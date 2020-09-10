package com.fiap.aoj.nexflix.titulo.dto;

public class Votacao {

	private Integer idUsuario;
	private Integer idTitulo;
	private Integer voto;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public Integer getIdTitulo() {
		return idTitulo;
	}

	public Integer getVoto() {
		return voto;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setIdTitulo(Integer idTitulo) {
		this.idTitulo = idTitulo;
	}

	public void setVoto(Integer voto) {
		this.voto = voto;
	}

}
