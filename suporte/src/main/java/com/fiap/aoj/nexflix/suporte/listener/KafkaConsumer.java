package com.fiap.aoj.nexflix.suporte.listener;

import com.fiap.aoj.nexflix.suporte.model.ChamadoUsuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {



    //Listener  for the userInfo
    @KafkaListener (topics="${usuario.info.topic}", groupId="${spring.kafka.consumer.usuario-info.group-id}")
    public void consume(String message){
        System.out.println("Consumed message: "+message+" Topico: :  usuario.info.topic - groupId:spring.kafka.consumer.usuario-info.group-id");
    }

    //Listener for the chamado

    @KafkaListener (topics="${usuario.chamado.topic}", groupId="${spring.kafka.consumer.usuario-chamado.group-id}",containerFactory = "chamadoUsuarioKafkaListenerFactory")
    public void consumeJson(ChamadoUsuario chamado){
        System.out.println("Consumed JSON message: "+chamado+" Topico: : usuario.chamado.topic - groupId: spring.kafka.consumer.usuario-chamado.group-id");
    }
}
