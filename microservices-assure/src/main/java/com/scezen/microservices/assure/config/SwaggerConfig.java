package com.scezen.microservices.assure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration    
@EnableSwagger2    
public class SwaggerConfig {
    @Bean    
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.scezen.microservices.controller"))
                .paths(PathSelectors.regex("/previt.*"))
                .build();
    }
    
    public SwaggerConfig() {
        // TODO Auto-generated constructor stub
    }
    
}