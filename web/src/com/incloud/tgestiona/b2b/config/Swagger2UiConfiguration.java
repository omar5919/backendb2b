package com.incloud.tgestiona.b2b.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
public class Swagger2UiConfiguration {

	private final Logger log = LoggerFactory.getLogger(Swagger2UiConfiguration.class);

	@Bean
	public Docket api() {

		log.debug("Starting Swagger");
		StopWatch watch = new StopWatch();
		watch.start();

		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				// .pathMapping("/api")
				.select().apis(RequestHandlerSelectors.basePackage("com.incloud.tgestiona.b2b.services.rest"))
				.paths(PathSelectors.any())
				// .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
				.build().apiInfo(apiInfo()).genericModelSubstitutes(ResponseEntity.class);

		watch.stop();
		log.debug("Started Swagger in {} ms", watch.getTotalTimeMillis());
		return docket;

		// Docket docket = Docket(DocumentationType.SWAGGER_2)
		// .apiInfo(new ApiInfoBuilder().title("Telefonica Empresas - Proyecto Business
		// 2 Business")
		// .description("Business two
		// Business").version("1.0a").license("Unlicense").build())
		// .select().apis(RequestHandlerSelectors.basePackage("com.pe.tgestiona.b2b.services.rest"))
		// .paths(PathSelectors.any()).build();

	}

	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * //enabling swagger-ui part for visual documentation
	 * registry.addResourceHandler("swagger-ui.html").addResourceLocations(
	 * "classpath:/resources/");
	 * registry.addResourceHandler("/webjars/**").addResourceLocations(
	 * "classpath:/resources/webjars/"); }
	 */

	private ApiInfo apiInfo() {
		return new ApiInfo("Telefónica Empresas - Proyecto Business 2 Business - Provisioner",
				"Aplicación de TeleComunicaciones", "Backend 2.0", "Derechos reservados", null,
				"License of API", "API license URL", Collections.emptyList());
	}

}
