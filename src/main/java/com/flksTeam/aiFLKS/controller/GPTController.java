package com.flksTeam.aiFLKS.controller;


import com.flksTeam.aiFLKS.chatgpt.ChatGPTClient;
import com.flksTeam.aiFLKS.model.GPTObject;
import com.flksTeam.aiFLKS.service.CodeGenerationGPTService;
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
    @Autowired
    private CodeGenerationGPTService codeGenerationGPTService;

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


    @GetMapping("/codeGenerationByForm")
    public String codeGenerationByForm() {
        return "formGPTCodeGenerator";
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

    @GetMapping("/")
    public String queryGPT() {
        return "gptForm";
    }

    @GetMapping("/codeGenerationByTable")
    public String codeGenerationByTable() {
        return "plainTextGPTCodeGenerator";
    }

    @PostMapping("/queryGPT")
    public String processQuery(RedirectAttributes redirectAttributes, @ModelAttribute GPTObject gptObject) {
        String response = sendToAI(gptObject.getRequestText());
        gptObject.setResponseText(response);
        redirectAttributes.addFlashAttribute(gptObject);
        return "redirect:/api/gpt/queryGPT";
    }

    @PostMapping("/codeGenerationByTable")
    public String codeGenerationByTable(RedirectAttributes redirectAttributes, @ModelAttribute GPTObject gptObject) {
        String textQuery = gptObject.getRequestText();
//        String response = sendToAI(gptObject.getRequestText());
        String response = codeGenerationGPTService.processTextSendToAIAndGetResponse(textQuery);

        gptObject.setResponseText(response);
        redirectAttributes.addFlashAttribute(gptObject);
        return "redirect:/api/gpt/codeGenerationByTable";
    }


    @ModelAttribute
    public GPTObject getGptObject() {
        return new GPTObject();
    }


    //String responseFromGPT = sequeryGPTndToAI("hello world");



}
