package com.stackroute.userservice.swaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {

	return new Docket(DocumentationType.SWAGGER_2).groupName("cplayer").apiInfo(apiInfo()).select()

	.paths(regex("/api/v1.*")).build();

	}



	private ApiInfo apiInfo() {

	return new ApiInfoBuilder().title("CPlayer")

	.description("User Sevice CPlayer Project Batch-10 team-07 ")

	.termsOfServiceUrl("")

	.license("Team")

	.licenseUrl("").version("1.0").build();

	}
}
