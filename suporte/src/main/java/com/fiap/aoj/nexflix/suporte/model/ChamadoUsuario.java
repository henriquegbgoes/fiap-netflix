package com.fiap.aoj.nexflix.suporte.model;

public class ChamadoUsuario {
    private String codigoCliente;
    private String messageChamado;

    public String getMessageChamado() {
        return messageChamado;
    }

    public void setMessageChamado(String messageChamado) {
        this.messageChamado = messageChamado;
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
    public ChamadoUsuario(String codigoCliente,String messageChamado){
        System.out.println("dados:"+ codigoCliente + " - "+messageChamado);
        this.codigoCliente=codigoCliente;
        this.messageChamado=messageChamado;
    }
}
