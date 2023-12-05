package com.mvc.spring.web.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenApi() {
        return  new OpenAPI()
                .info(new Info()
                        .title("API practicando MVC")
                        .version("1.0")
                        .description("Aprendiendo a estucturar mi proyecto con MVC usando spring 3")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
