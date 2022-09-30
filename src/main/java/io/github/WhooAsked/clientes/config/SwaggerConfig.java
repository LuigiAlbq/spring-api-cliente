package io.github.WhooAsked.clientes.config;

import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


public class SwaggerConfig {

        @Bean
        public OpenAPI openApiConfig() {
            return new OpenAPI().info(apiInfo());
        }

        public Info apiInfo() {
            Info info = new Info();
            info
                    .title("ACT Web Proxy")
                    .version("v1.0.0");
            return info;
        }

    }


