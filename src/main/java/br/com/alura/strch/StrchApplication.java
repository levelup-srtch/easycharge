package br.com.alura.strch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class StrchApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrchApplication.class, args);
	}

}
