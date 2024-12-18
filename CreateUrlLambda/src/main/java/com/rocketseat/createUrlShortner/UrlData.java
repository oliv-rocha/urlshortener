package com.rocketseat.createUrlShortner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UrlData {
    private String originalUrl; // Campo para armazenar a URL original
    private long expirationTime; // Campo para armazenar o tempo de expiração em segundos

    // O Lombok irá gerar automaticamente o construtor que recebe os dois campos e os métodos getter/setter
}
