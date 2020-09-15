package com.example.tbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.OnError;

@SpringBootApplication
@RestController
public class TbdApplication {

	public static void main(String[] args) {
		SpringApplication.run(TbdApplication.class, args);
	}

	@GetMapping("/")
	public String mostrarInicio(){
		return "Esta es la página de inicio uwu";
	}

}
