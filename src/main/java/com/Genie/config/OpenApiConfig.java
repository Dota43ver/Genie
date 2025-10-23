package com.Genie.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Genie API",
                version = "0.0.1-SNAPSHOT",
                description = "API para el proyecto Genie (Algoritmos Genéticos y Autenticación)"
        ),
        // Aplica el candado de seguridad a todos los endpoints (excepto los públicos)
        security = @SecurityRequirement(name = "bearerAuth")
)
@SecurityScheme(
        name = "bearerAuth", // Nombre de referencia
        description = "JWT Bearer Token",
        scheme = "bearer", // Esquema (bearer)
        type = SecuritySchemeType.HTTP, // Tipo de seguridad
        bearerFormat = "JWT", // Formato
        in = SecuritySchemeIn.HEADER // Dónde se envía (en el Header)
)
public class OpenApiConfig {
}
