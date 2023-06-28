package com.scezen.microservices.assure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("scezen.microservices")
@RefreshScope
public class ApplicationPropertiesConfiguration {

	private int limiteNombreAssure;

	public int getLimiteNombreAssure() {
		return limiteNombreAssure;
	}

	public void setLimiteNombreAssure(int limiteNombreAssure) {
		this.limiteNombreAssure = limiteNombreAssure;
	}

}
