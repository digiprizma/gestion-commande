package com.digiprisma.infra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerAutoConfiguration {

  @Autowired
  private BuildProperties buildProperties;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Digiprizma : "+buildProperties.getName()).select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.cloud")))
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.data.rest.webmvc")))
				.paths(PathSelectors.any()).build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Digiprizma").description("REST API for The Digiprizma gestion-commerciale")
				.version("Development : "+buildProperties.getVersion()).contact(new Contact("Digiprizma (Gestion-commande)",
						"https://www.digiprizma.com/", "EQUIPE_INTEGREE@digiprizma.com"))
				.build();
	}

}
