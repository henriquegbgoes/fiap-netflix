package com.fiap.aoj.nexflix.usuario.model;

public class Usuario {

    private String identifier;
    private String nome;
    private String codigoCliente;

    public Usuario(String identifier, String nome, String codigoCliente){
        this.identifier=identifier;
        this.nome=nome;
        this.codigoCliente=codigoCliente;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
}
