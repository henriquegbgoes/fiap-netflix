package com.fiap.aoj.nexflix.suporte.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fiap.aoj.nexflix.suporte.model.Suporte;
import com.fiap.aoj.nexflix.suporte.service.SuporteService;
import com.google.gson.Gson;

@Service
@EnableBinding(Sink.class)
public class ConsumerService {
	
	@Autowired
	private SuporteService suporteService;

	@StreamListener(target = Sink.INPUT)
	public void consumerProductEvent(@Payload String jsonString) {
		Gson g = new Gson(); 
		Suporte suporte = g.fromJson(jsonString, Suporte.class);
		String response = suporteService.abrirChamado(suporte);
		System.out.println("Received a product {} " + response + " for " + jsonString);
	}

}
