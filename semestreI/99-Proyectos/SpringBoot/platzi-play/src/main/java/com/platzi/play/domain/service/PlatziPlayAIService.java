package com.platzi.play.domain.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.V;

@AiService
public interface PlatziPlayAIService {

    @UserMessage(
            """
            Genera un saludo de bienvenida a la platform de Gestion de Peliculas {{plataform}}
            Usa menos de 120 caracteres y hazlo con el estilo Platzi.
            """
    )
    String generateGreeting(@V("plataform") String plataform);
}
