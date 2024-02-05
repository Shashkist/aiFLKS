package com.flksTeam.aiFLKS.chatgpt;

import okhttp3.*;

import java.io.IOException;

public class ChatGPTClient {
    private static final String API_ENDPOINT = "https://api.openai.com/v1/completions";
    private final String apiKey;

    public ChatGPTClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public String sendToAI(String textQuery) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");

        // Create the JSON request body
        String json = "{\"prompt\": \"" + textQuery + "\", \"model\": \"gpt-3.5-turbo-instruct\", \"max_tokens\": 150}";

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
            // Return the response body as text
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception to propagate it to the caller
        }
    }
}