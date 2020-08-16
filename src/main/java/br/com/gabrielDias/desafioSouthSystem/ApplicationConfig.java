package br.com.gabrielDias.desafioSouthSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EntityScan(basePackages = {"br.com.gabrielDias.desafioSouthSystem.entity"})
@EnableJpaRepositories(basePackages = {"br.com.gabrielDias.desafioSouthSystem.repository"})
@ComponentScan(basePackages = {"br.com.gabrielDias.desafioSouthSystem.controller", "br.com.gabrielDias.desafioSouthSystem.services"})
public class ApplicationConfig {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfig.class, args);
	}

}
