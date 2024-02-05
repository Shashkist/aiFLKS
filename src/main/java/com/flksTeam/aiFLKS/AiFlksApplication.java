package com.flksTeam.aiFLKS;

import com.flksTeam.aiFLKS.chatgpt.ChatGPTClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AiFlksApplication {

	public static String secretKey ="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";

	public static void main(String[] args) {
//		SpringApplication.run(AiFlksApplication.class, args);
		String apiKey = secretKey;
		String textQuery = "Hello, how are you?";

		ChatGPTClient chatGPTClient = new ChatGPTClient(apiKey);

		try {
			String response = chatGPTClient.sendToAI(textQuery);
			System.out.println("Response from ChatGPT: " + response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String sendToAI(String textQuery, String key) {
		String response = "";
		//sending request....
		// getting response as a text from AI
		return response;
	}

}
