package com.flksTeam.aiFLKS;

import com.flksTeam.aiFLKS.chatgpt.ChatGPTClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AiFlksApplication {


	public static String textQuery = "Hello, how are you?";

	@Autowired
	private ChatGPTClient chatGPTClient ;

	public static void main(String[] args) {
		SpringApplication.run(AiFlksApplication.class, args);

	}



}
