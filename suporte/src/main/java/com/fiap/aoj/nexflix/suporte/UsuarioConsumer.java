package com.fiap.aoj.nexflix.suporte;

import com.fiap.aoj.netflix.suporte.model.Usuario;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UsuarioConsumer {

    @KafkaListener(topics = "${usuario.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final ConsumerRecord<String, Usuario> consumerRecord) {
        log.info("key: " + consumerRecord.key());
        log.info("Headers: " + consumerRecord.headers());
        log.info("Partition: " + consumerRecord.partition());
        log.info("Ticket: " + consumerRecord.value());
    }
}