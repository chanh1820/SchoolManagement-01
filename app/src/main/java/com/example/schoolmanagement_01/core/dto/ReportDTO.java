package com.example.schoolmanagement_01.core.dto;

public class ReportDTO {

    private Integer id;

    private String week;

    private String classRoom;

    private String ruleName;

    private String studentName;

    private Integer minusPoint;

    private String pathImage;

    public ReportDTO() {}

    public ReportDTO(Integer id, String week, String classRoom, String ruleName, String studentName, Integer minusPoint, String pathImage) {
        this.id = id;
        this.week = week;
        this.classRoom = classRoom;
        this.ruleName = ruleName;
        this.studentName = studentName;
        this.minusPoint = minusPoint;
        this.pathImage = pathImage;
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
}
