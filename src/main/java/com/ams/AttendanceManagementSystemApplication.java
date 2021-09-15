package com.ams;

import org.apache.logging.log4j.Logger;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AttendanceManagementSystemApplication {
	
	private final static Logger LOGGER = LogManager.getLogger(AttendanceManagementSystemApplication.class);
	
	public static void main(String[] args){
		SpringApplication.run(AttendanceManagementSystemApplication.class, args);
		LOGGER.info("\n~~~~~~~~~~~~~~~~~~~~~\nCONNECTED TO DB\n~~~~~~~~~~~~~~~~~~~~~");
		}
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("com")).build();
     }
	
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
				"Accept","Authorization","Origin , Accept","X-Requested-With",
				"Access-Control-Request-Method","Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Type",
				"Accept","Authorization","Access-Control-Allow-Origin","Access-Control-Allow-Origin","Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfiguration=new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfiguration.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfiguration);
	}
	
}
