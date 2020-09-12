package com.fiap.aoj.nexflix.suporte.config;

import com.fiap.aoj.nexflix.suporte.model.ChamadoUsuario;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import com.fiap.aoj.nexflix.suporte.dto.Suporte;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfiguration {

    @Bean
    public ConsumerFactory<String,String> consumerFactory(){
        Map<String,Object> config=new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092"); //Kafka running on local and in this port
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"${spring.kafka.consumer.usuario-info.group-id}"); //group_id to manage many topics
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<String, String>(config);
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory kafkaListenerContainerFactory(){

        ConcurrentKafkaListenerContainerFactory <String,String>factory = new ConcurrentKafkaListenerContainerFactory();

        factory.setConsumerFactory(consumerFactory());

        return factory;
    }

    @Bean
    public ConsumerFactory<String, ChamadoUsuario> userChamadoConsumerFactory(){
        Map<String,Object> config=new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092"); //Kafka running on local and in this port
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"${spring.kafka.consumer.usuario-chamado.group-id}"); //group_id to manage many topics
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);


        return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),
                new ErrorHandlingDeserializer(new JsonDeserializer<>(ChamadoUsuario.class)));
        //    {"identifier":"1234","nomeUsuario":"Reinaldo","codigoCliente":"007","messageChamado":"Ta down meu servico po!"}

//        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
//                new JsonDeserializer<>(ChamadoUsuario.class));

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory <String, ChamadoUsuario>chamadoUsuarioKafkaListenerFactory(){

        ConcurrentKafkaListenerContainerFactory <String, ChamadoUsuario> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(userChamadoConsumerFactory());

        return factory;
    }


    //AbrirChamado

    @Bean
    public ConsumerFactory<String, Suporte> abrirChamadoConsumerFactory(){
        Map<String,Object> config=new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"${spring.kafka.consumer.abrir-chamado.group-id}");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),
                new ErrorHandlingDeserializer(new JsonDeserializer<>(Suporte.class)));

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory <String, Suporte>abrirChamadoUsuarioKafkaListenerFactory(){

        ConcurrentKafkaListenerContainerFactory <String, Suporte> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(abrirChamadoConsumerFactory());

        return factory;
    }


}