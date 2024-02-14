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
        finalQuery += " for that table: ";
        finalQuery += textQuery;
//        finalQuery += " the answer should be the java code which contains only the getters and setters and no text";
//        finalQuery += " there should not be class definition - only getters and setters in java";
        finalQuery += "please go after the table fields ";
        finalQuery += "just the java code no additional text or tags i want only the java class with the getters and setters static fields etc :\n" ;
        finalQuery += "generate class based on the table above, try to create methods based on the information in the 'source from idit' column here the code example: ";
        finalQuery += "@IDITVORegistration(isVOHasJDO = true)\n" +
                "public class ContactFLKSIVO extends ContactIVO {\n" +
                "    public static final String CUSTOMER_NUMBER = \"customerNumber\";\n" +
                "    static {\n" +
                "        initContactAddressFLKSIVOAttributes(EntityNrConstants.ContactIVO, ContactFLKSIVO.class, ContactIVO.class);\n" +
                "    }\n" +
                "    protected static VOAttributesMap initContactAddressFLKSIVOAttributes(Long entityNr, Class extDataIVOClass, Class coreIVOClass) {\n" +
                "        VOAttributesMap attributes = initExtDataVOAttributes(entityNr, extDataIVOClass, coreIVOClass);\n" +
                "        attributes.setAttribute(CUSTOMER_NUMBER, String.class, IDITFieldDescriptor.SIMPLE);\n" +
                "        return attributes;\n" +
                "    }\n" +
                "    public ContactFLKSIVO() {\n" +
                "        super();\n" +
                "    }\n" +
                "}";

        System.out.println(finalQuery);
        return finalQuery;


    }

    private String queryContext1(String textQuery) {
        String finalQuery = "";
        finalQuery += " for that table: ";
        finalQuery += textQuery;
//        finalQuery += " the answer should be the java code which contains only the getters and setters and no text";
//        finalQuery += " there should not be class definition - only getters and setters in java";
        finalQuery += "please go after the table fields ";
        finalQuery += "just the java code no additional text or tags i want only the java class with the getters and setters static fields etc :\n" ;
        finalQuery += "generate class based on the table above, try to create methods based on the information in the 'source from idit' column here the code example: ";
        finalQuery += "@IDITVORegistration(isVOHasJDO = true)\n" +
                "public class ContactFLKSIVO extends ContactIVO {\n" +
                "    public static final String CUSTOMER_NUMBER = \"customerNumber\";\n" +
                "    static {\n" +
                "        initContactAddressFLKSIVOAttributes(EntityNrConstants.ContactIVO, ContactFLKSIVO.class, ContactIVO.class);\n" +
                "    }\n" +
                "    protected static VOAttributesMap initContactAddressFLKSIVOAttributes(Long entityNr, Class extDataIVOClass, Class coreIVOClass) {\n" +
                "        VOAttributesMap attributes = initExtDataVOAttributes(entityNr, extDataIVOClass, coreIVOClass);\n" +
                "        attributes.setAttribute(CUSTOMER_NUMBER, String.class, IDITFieldDescriptor.SIMPLE);\n" +
                "        return attributes;\n" +
                "    }\n" +
                "    public ContactFLKSIVO() {\n" +
                "        super();\n" +
                "    }\n" +
                "}";

        System.out.println(finalQuery);
        return finalQuery;


    }

    private String queryContext2(String textQuery) {
        String finalQuery = "";
        finalQuery += " for that table: ";
        finalQuery += textQuery;
//        finalQuery += " the answer should be the java code which contains only the getters and setters and no text";
//        finalQuery += " there should not be class definition - only getters and setters in java";
        finalQuery += "please go after the table fields ";
        finalQuery += "just the java code no additional text or tags i want only the java class with the getters and setters static fields etc :\n" ;
        finalQuery += "generate class based on the table above, try to create methods based on the information in the 'source from idit' column here the code example: ";
        finalQuery += "@IDITVORegistration(isVOHasJDO = true)\n" +
                "public class ContactFLKSIVO extends ContactIVO {\n" +
                "    public static final String CUSTOMER_NUMBER = \"customerNumber\";\n" +
                "    static {\n" +
                "        initContactAddressFLKSIVOAttributes(EntityNrConstants.ContactIVO, ContactFLKSIVO.class, ContactIVO.class);\n" +
                "    }\n" +
                "    protected static VOAttributesMap initContactAddressFLKSIVOAttributes(Long entityNr, Class extDataIVOClass, Class coreIVOClass) {\n" +
                "        VOAttributesMap attributes = initExtDataVOAttributes(entityNr, extDataIVOClass, coreIVOClass);\n" +
                "        attributes.setAttribute(CUSTOMER_NUMBER, String.class, IDITFieldDescriptor.SIMPLE);\n" +
                "        return attributes;\n" +
                "    }\n" +
                "    public ContactFLKSIVO() {\n" +
                "        super();\n" +
                "    }\n" +
                "}";

        System.out.println(finalQuery);
        return finalQuery;


    }
}
