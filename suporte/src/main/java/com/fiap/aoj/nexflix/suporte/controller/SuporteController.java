package com.fiap.aoj.nexflix.suporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.aoj.nexflix.suporte.dto.Suporte;
import com.fiap.aoj.nexflix.suporte.service.SuporteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/suporte") 
@Api(value = "API REST Suporte Netflix")
@CrossOrigin(origins = "*")





public class SuporteController {
	
	@Autowired
	private SuporteService service;


	@PostMapping("/abrirChamado")
	@ApiOperation(value = "Votar em um Título")
	public String votarTitulo(@RequestBody Suporte suporte) {return service.abrirChamado(suporte);}
}
