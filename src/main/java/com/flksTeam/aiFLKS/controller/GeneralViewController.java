package com.flksTeam.aiFLKS.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GeneralViewController implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/redirect-to-queryWithText").setViewName("redirect:/api/gpt/codeGenerationByTable");
        registry.addViewController("/redirect-to-queryWithForm").setViewName("redirect:/api/gpt/codeGenerationByForm");
        registry.addViewController("").setViewName("home");
        //TODO to change
        registry.addViewController("/redirect-to-queryWithImage").setViewName("redirect:/api/gpt/higpt");
        registry.addViewController("/redirect-to-justChat").setViewName("redirect:/api/gpt/queryGPT");

    }
}

