package com.example.schoolmanagement_01.core.dto;

public class RuleDTO {
    private Integer id;

    private String ruleName;

    private Integer minusPoint;

    public RuleDTO(Integer id, String ruleName, Integer minusPoint) {
        this.id = id;
        this.ruleName = ruleName;
        this.minusPoint = minusPoint;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getMinusPoint() {
        return minusPoint;
    }

    public void setMinusPoint(Integer minusPoint) {
        this.minusPoint = minusPoint;
    }
}
