package com.fiap.aoj.nexflix.suporte.model;

public class ChamadoUsuario {
    private String identifier;
    private String nomeUsuario;
    private String codigoCliente;
    private String messageChamado;

    public String getMessageChamado() {
        return messageChamado;
    }

    public void setMessageChamado(String messageChamado) {
        this.messageChamado = messageChamado;
    }


    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getNome() {
        return nomeUsuario;
    }

    public void setNome(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    //default constructor
    public ChamadoUsuario(){

    }
    public ChamadoUsuario(String identifier, String nomeUsuario, String codigoCliente,String messageChamado){
        this.identifier=identifier;
        this.nomeUsuario=nomeUsuario;
        this.codigoCliente=codigoCliente;
        this.messageChamado=messageChamado;
    }
}
