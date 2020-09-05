package com.fiap.aoj.nexflix.usuario;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Component
public class UsuarioProducer {

    @Value("${usuario.topic}")
    private String usuarioTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public UsuarioProducer(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(final @RequestBody String ticket) {
        final String mensageKey = UUID.randomUUID().toString();
        kafkaTemplate.send(usuarioTopic, mensageKey,  ticket);
    }

}
