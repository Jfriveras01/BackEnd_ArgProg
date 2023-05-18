package com.portafolioargprog.primer.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PrimerProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimerProyectoApplication.class, args);
	}
        
        public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("https://front-end-argprograma.web.app");
			}
		};
	}
}
