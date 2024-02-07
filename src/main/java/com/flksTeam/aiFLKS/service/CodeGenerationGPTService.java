package com.flksTeam.aiFLKS.service;


import com.flksTeam.aiFLKS.chatgpt.ChatGPTClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Data
public class CodeGenerationGPTService {
    @Autowired
    private ChatGPTClient chatGPTClient ;

    public String processTextSendToAIAndGetResponse(String textQuery) {
        String response = "";
        String nexTextQuery = decorateTextQuery(textQuery);
        try {
            response = chatGPTClient.sendToAI(nexTextQuery);
            System.out.println("Response from ChatGPT: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //sending request....
        // getting response as a text from AI
        return response;
    }

    private String decorateTextQuery(String textQuery) {
        String finalQuery = "";
        finalQuery += " for that table:";
        finalQuery += textQuery;
//        finalQuery += " the answer should be the java code which contains only the getters and setters and no text";
//        finalQuery += " there should not be class definition - only getters and setters in java";
        finalQuery += "please go after the table fields  no additional words like :code";
        finalQuery += "just the code no additional text or tags i want only the class with the getters and setters:\n" +
                "format should be like : public boolean isForceExternal() {\n" +
                "        return (boolean) get(FORCE_EXTERNAL);\n" +
                "    }\n" +
                "\n" +
                "    public void setForceExternal(boolean forceExternal) {\n" +
                "        set(FORCE_EXTERNAL, forceExternal);\n" +
                "    }";

        finalQuery += "please follow the format below:";
        finalQuery += "@IDITVORegistration(isVOHasJDO = true)\n" +
                "public class ContactFLKSIVO extends ContactIVO {\n" +
                "\n" +
                "    public static final String CUSTOMER_NUMBER = \"customerNumber\";\n" +
                "    \n" +
                "\n" +
                "    static {\n" +
                "        initContactAddressFLKSIVOAttributes(EntityNrConstants.ContactIVO, ContactFLKSIVO.class, ContactIVO.class);\n" +
                "    }\n" +
                "\n" +
                "    protected static VOAttributesMap initContactAddressFLKSIVOAttributes(Long entityNr, Class extDataIVOClass, Class coreIVOClass) {\n" +
                "        VOAttributesMap attributes = initExtDataVOAttributes(entityNr, extDataIVOClass, coreIVOClass);\n" +
                "        attributes.setAttribute(CUSTOMER_NUMBER, String.class, IDITFieldDescriptor.SIMPLE);\n" +
                "     \n" +
                "        return attributes;\n" +
                "    }\n" +
                "\n" +
                "    public ContactFLKSIVO() {\n" +
                "        super();\n" +
                "    }\n" +
                "\n" +
                "}";
        return finalQuery;


    }
}
