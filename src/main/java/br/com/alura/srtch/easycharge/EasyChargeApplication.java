package br.com.alura.srtch.easycharge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableSpringDataWebSupport
public class EasyChargeApplication {

	public static void main(String[] args) {
		  SpringApplication.run(EasyChargeApplication.class, args);
		
		  
		
	}

	
	
}
