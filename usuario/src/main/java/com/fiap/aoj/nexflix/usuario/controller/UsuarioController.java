package com.fiap.aoj.nexflix.usuario.controller;

import com.fiap.aoj.nexflix.usuario.UsuarioProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/ticket")
@Slf4j
public class UsuarioController {

    private final UsuarioProducer usuarioProducer;

    public UsuarioController(UsuarioProducer usuarioProducer) {
        this.usuarioProducer = usuarioProducer;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void send(@RequestBody String ticket) {
        usuarioProducer.send(ticket);
    }
}
