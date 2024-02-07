package com.flksTeam.aiFLKS.model;

import lombok.Data;

@Data
public class GPTFormLine {
    private String fieldName;
    private String fieldType;
    private String sourceFromIdit;
    private boolean isMandatory;
}
