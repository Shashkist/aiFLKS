package com.flksTeam.aiFLKS.controller;


import com.flksTeam.aiFLKS.chatgpt.ChatGPTClient;
import com.flksTeam.aiFLKS.model.GPTObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/api/gpt")
public class GPTController {

    @Autowired
    private ChatGPTClient chatGPTClient ;

    @GetMapping()
    @ResponseBody
    public String home() {

        return "hello world";
    }

    @GetMapping("/higpt")
    @ResponseBody
    public String hiGPT() {

        String responseFromGPT = sendToAI("hello world");
        return responseFromGPT;
    }

    public String sendToAI(String textQuery) {
        String response = "";
        try {
            response = chatGPTClient.sendToAI(textQuery);
            System.out.println("Response from ChatGPT: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //sending request....
        // getting response as a text from AI
        return response;
    }

    @GetMapping("/queryGPT")
    public String queryGPT() {
        return "gptForm";
    }

    @PostMapping("/queryGPT")
    public String processQuery(RedirectAttributes redirectAttributes, @ModelAttribute GPTObject gptObject) {
        String response = sendToAI(gptObject.getRequestText());
        gptObject.setResponseText(response);
        redirectAttributes.addFlashAttribute(gptObject);
        return "redirect:/api/gpt/queryGPT";
    }


    @ModelAttribute
    public GPTObject getGptObject() {
        return new GPTObject();
    }


    //String responseFromGPT = sendToAI("hello world");



}
