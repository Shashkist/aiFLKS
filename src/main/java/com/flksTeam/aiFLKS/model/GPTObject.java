package com.flksTeam.aiFLKS.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GPTObject {
    private String responseText;
    private String requestText;

    private List<GPTFormLine> gptFormLineList = new ArrayList<>(0);






}
