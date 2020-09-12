package com.fiap.aoj.nexflix.suporte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.aoj.nexflix.suporte.dto.Suporte;
import com.fiap.aoj.nexflix.suporte.repository.DBRepository;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;

import org.json.JSONObject;
@Service
public class SuporteService {

	@Autowired
	private DBRepository dbRepository;

	private KafkaTemplate<String, Suporte> kafkaTemplate;


	//Adding kafka
	@Value("${abrir.chamado.topic}")
	private String TOPIC;

	public String abrirChamado(Suporte suporte) {
		List<Object> result = dbRepository.callProcedure(suporte, "sp_incluir_suporte");
		if(result.contains(Boolean.TRUE)) {
			System.out.println("TESTE ENVIANDO suporte JSON TO KAFKA topic");
			System.out.println(suporte);
			ObjectMapper mapper = new ObjectMapper();
			try {
				String jsonString = mapper.writeValueAsString(suporte);
				System.out.println("ResultingJSONstring = " + jsonString);

//				Gson gson = new Gson();
//				String json=gson.toJson(suporte);
//				System.out.println( json);

//				kafkaTemplate.send(TOPIC, new Suporte(json.idUsuario,json.idTitulo,json.tipoProblema,json.nomeDispositivo ,json.tipoDispositivo,json.descricao));
//				JSONObject json = new JSONObject();
//				json = mapper.writeValue(new File("target/suporte.json"), suporte);


//				kafkaTemplate.send(TOPIC, );

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			return "Chamado Aberto com sucesso!!!";
		}
		else 
			return "Não foi possível abrir o chamado!!!";
	}

}
