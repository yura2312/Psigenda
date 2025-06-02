package com.psigenda.psigenda.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
//@SecurityScheme(
//        name = "bearerAuth",
//        type = SecuritySchemeType.HTTP,
//        scheme = "bearer"
//)
public class SwaggerConfig {

    public OpenAPI getOpenAPI() {

        Contact contact = new Contact();
        contact.name("Gabriel Daiki");
        contact.email("daiki.gab@gmail.com");


        Info info = new Info();
        info.title("API REST Psigenda");
        info.version("1.0.0");
        info.description("API de agendamento de psicologos e pacientes");
        info.contact(contact);
        return new OpenAPI().info(info);
    }
    }
