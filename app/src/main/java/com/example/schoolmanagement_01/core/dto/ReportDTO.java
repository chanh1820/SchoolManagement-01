package com.example.schoolmanagement_01.core.dto;

public class ReportDTO {

    private Integer id;

    private String week;

    private String classRoom;

    private String ruleName;

    private Integer ruleId;

    private String studentName;

    private Integer minusPoint;

    private String pathImage;

    private String createdDate;

    public ReportDTO() {}

    public ReportDTO(Integer id, String week, String classRoom, String ruleName, String studentName,Integer ruleId, Integer minusPoint, String pathImage, String createdDate) {
        this.id = id;
        this.week = week;
        this.classRoom = classRoom;
        this.ruleName = ruleName;
        this.ruleId = ruleId;
        this.studentName = studentName;
        this.minusPoint = minusPoint;
        this.pathImage = pathImage;
        this.createdDate = createdDate;
    }

    public ReportDTO(Integer ruleId, Integer minusPoint) {
        this.ruleId = ruleId;
        this.minusPoint = minusPoint;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getMinusPoint() {
        return minusPoint;
    }

    public void setMinusPoint(Integer minusPoint) {
        this.minusPoint = minusPoint;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
