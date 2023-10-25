package com.test.banco.configs;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

public class OpenApiConfig {
	
	
	@Value("${banco.opeanapi.dev-url}")
	public String devUrl;
	
	@Value("${banco.opeanapi.prod-url}")
	public String prodUrl;
	
	@Bean
	public OpenAPI myOpenAPI() {
		Server devServ = new Server();
		devServ.setUrl(devUrl);
		devServ.setDescription("URL de Desenvolvimento");
		
		Server prodServ = new Server();
		prodServ.setUrl(prodUrl);
		prodServ.setDescription("URL de produção");
		
		Contact contato = new Contact();
		contato.setEmail("wosley.mares@gmail.com");
		contato.setName("wosley.mares");
		contato.setUrl("Url");
		
		Info info = new Info()
				.title("API para teste em aplicação bancária")
				.version("1.0")
				.contact(contato)
				.description("API para endpoints da aplicação");
		
		return new OpenAPI()
				.info(info)
				.servers(List.of(devServ,prodServ));

		
	}

}
