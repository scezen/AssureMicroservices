package com.scezen.microservices.contrat_mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MicroservicesContratMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesContratMongodbApplication.class, args);
	}

}
