package com.flksTeam.aiFLKS.chatgpt;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChatGPTClient {
    @Value("${openai.api-key}")
    private static String secretKey;
//    public static String secretKey ="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";

    private static final String API_ENDPOINT = "https://api.openai.com/v1/completions";
    private final String apiKey;

    public ChatGPTClient() {
        this.apiKey = secretKey;
    }

    public String sendToAI(String textQuery) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .callTimeout(60, TimeUnit.SECONDS) // Set the call timeout to 60 seconds
                .connectTimeout(60, TimeUnit.SECONDS) // Set the connection timeout
                .readTimeout(60, TimeUnit.SECONDS) // Set the read timeout
                .writeTimeout(60, TimeUnit.SECONDS) // Set the write timeout
                .build();

        MediaType mediaType = MediaType.parse("application/json");

        // Construct the request body as a Map and serialize it to JSON
        Map<String, Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("prompt", textQuery);
        requestBodyMap.put("model", "gpt-3.5-turbo-instruct");
        requestBodyMap.put("max_tokens", 900);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(requestBodyMap);

        RequestBody body = RequestBody.create(json, mediaType);

        Request request = new Request.Builder()
                .url(API_ENDPOINT)
                .post(body)
                .addHeader("Authorization", "Bearer " + apiKey)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            // Parse the JSON response
            String responseBody = response.body().string();
            JsonNode rootNode = objectMapper.readTree(responseBody);
            System.out.println(rootNode);
            String textResponse = rootNode.get("choices").get(0).get("text").asText();
            return textResponse;
        } catch (IOException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception to propagate it to the caller
        }
    }
}
