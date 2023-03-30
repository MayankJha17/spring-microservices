package com.spring.userService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.spring.userService.endpoint")).paths(PathSelectors.any())
				.build();
	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Thinkfully REST API",
				"<h3>Security</h3> <p>We have JWT scurity enabled APIs, so each service (except login and sign-up/registration) would require auth token, which can be created using login service on successful login and we need to pass in request header as Authorization: Bearer [token].",
				"1.0", "Terms of service", new Contact("Arishi", "https://www.arishi.agency", "info@arishi.agency"), "",
				"", Collections.emptyList());
	}

}
