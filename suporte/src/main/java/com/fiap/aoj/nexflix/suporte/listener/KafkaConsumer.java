package com.fiap.aoj.nexflix.suporte.listener;

import com.fiap.aoj.nexflix.suporte.model.ChamadoUsuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fiap.aoj.nexflix.suporte.dto.Suporte;

@Service
public class KafkaConsumer {



    //Listener  for the userInfo
    @KafkaListener (topics="${usuario.info.topic}", groupId="${spring.kafka.consumer.usuario-info.group-id}")
    public void consume(String message){
        System.out.println("Consumed message: "+message+" Topico: :  usuario.info.topic - groupId:spring.kafka.consumer.usuario-info.group-id");
    }

    //Listener for the usuario chamado
    @KafkaListener (topics="${usuario.chamado.topic}", groupId="${spring.kafka.consumer.usuario-chamado.group-id}",containerFactory = "chamadoUsuarioKafkaListenerFactory")
    public void consumeJson(ChamadoUsuario chamado){
        System.out.println("Consumed JSON usuarioChamado: "+chamado);
    }

    //Listener for the abrirChamado

    @KafkaListener (topics="${abrir.chamado.topic}", groupId="${spring.kafka.consumer.abrir-chamado.group-id}",containerFactory = "abrirChamadoUsuarioKafkaListenerFactory")
    public void consumeAbrirChamado(Suporte suporte){
        System.out.println("Consumed JSON abrirChamado: "+ suporte);
    }
}
