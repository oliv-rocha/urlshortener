package com.rocketseat.createUrlShortner;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main implements RequestHandler<Map<String, Object>, Map<String, String>> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final S3Client s3Client = S3Client.builder().build();

    @Override
    public Map<String, String> handleRequest(Map<String, Object> input, Context context) {
        String body = input.get("body").toString();

        Map<String, String> bodyMap;
        try {
            bodyMap = objectMapper.readValue(body, Map.class);
        } catch (Exception exception) {
            throw new RuntimeException("Error parsing JSON body: " + exception.getMessage(), exception);
        }

        String originalUrl = bodyMap.get("originalUrl");
        String expirationTime = bodyMap.get("expirationTime");
        long expirationTimeInSeconds = Long.parseLong(expirationTime); // Converte para segundos

        String shortUrlCode = UUID.randomUUID().toString().substring(0, 8); // Gera um código de URL curta

        UrlData urlData = new UrlData(originalUrl, expirationTimeInSeconds);

        try {
            String urlDataJson = objectMapper.writeValueAsString(urlData);

            // Usando PutObjectRequest para salvar o objeto no S3
            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket("url-shortener-storage-oliv")  // Nome do bucket
                    .key(shortUrlCode + ".json")  // Nome do arquivo no S3
                    .build();

            // Realiza o upload do objeto para o S3
            s3Client.putObject(request, RequestBody.fromString(urlDataJson));
        } catch (Exception exception) {
            throw new RuntimeException("Error saving data to S3: " + exception.getMessage(), exception);
        }

        // Resposta com o código curto da URL
        Map<String, String> response = new HashMap<>();
        response.put("code", shortUrlCode);
        return response;
    }

    // Define a classe UrlData com os campos originalUrl e expirationTimeInSeconds
    public static class UrlData {
        private String originalUrl;
        private long expirationTimeInSeconds;

        public UrlData(String originalUrl, long expirationTimeInSeconds) {
            this.originalUrl = originalUrl;
            this.expirationTimeInSeconds = expirationTimeInSeconds;
        }

        public String getOriginalUrl() {
            return originalUrl;
        }

        public long getExpirationTimeInSeconds() {
            return expirationTimeInSeconds;
        }
    }
}
