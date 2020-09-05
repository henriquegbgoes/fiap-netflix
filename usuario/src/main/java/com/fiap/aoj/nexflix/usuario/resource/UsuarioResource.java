package com.fiap.aoj.nexflix.usuario.resource;

import com.fiap.aoj.nexflix.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("kafka")
public class UsuarioResource {

    @Autowired
    private KafkaTemplate<String, Usuario> kafkaTemplate;

    @Value("${usuario.topic}")
    private String TOPIC;

    @GetMapping("/usuario/chamado/{nome}")  // Use POST here for next
    public String post(@PathVariable("nome") final String nome) {

    //Publishing in kafka, using kafka template
        final String codigoCliente = UUID.randomUUID().toString();
        final String identifier="007";

        //Chamado ID
        final String chamadoId = UUID.randomUUID().toString();
    kafkaTemplate.send(TOPIC,new Usuario(identifier,nome,codigoCliente));


    return "Chamado aberto "+chamadoId+" exitosamente. Usuario: " + nome + "!";
    }


}
