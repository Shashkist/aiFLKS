package com.flksTeam.aiFLKS.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GPTObject {
    private String responseText;
    private String requestText;

    private List<GPTFormLine> gptFormLineList = new ArrayList<>(0);


    public void addNewRowToTheList() {
        GPTFormLine gptFormLine = new GPTFormLine();
        gptFormLine.setFieldName("");
        gptFormLine.setFieldType("");
        getGptFormLineList().add(gptFormLine);
    }
}
