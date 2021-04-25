package com.projetoavenue.controlepautas;

import com.projetoavenue.controlepautas.config.UserInfoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties({UserInfoConfig.class})
public class ControlePautasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlePautasApplication.class, args);
	}

}
