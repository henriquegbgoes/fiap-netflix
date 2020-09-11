package com.fiap.aoj.nexflix.suporte.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {        
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.regex("/suporte.*"))                          
          .build()
          .apiInfo(metaInfo());
    }
    
    
    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
        		"Suporte Netflix API REST", 
        		"API REST para Suporte Netflix.", 
        		"1.0", 
        		"Terms of Service", 
        		new springfox.documentation.service.Contact("Henrique Góes|RM336001 - \nJorge Mercado|RM336001 - \nReinaldo Santos|RM336001", "73AOJ", ""), 
        		"Apache License Version 2.0", 
        		"\"https://www.apache.org/licesen.html\"",
        		new ArrayList<VendorExtension>());

        return apiInfo;
    }
}