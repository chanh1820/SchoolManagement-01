package com.example.schoolmanagement_01.core.dto;

public class PointDTO {

    private Integer id;

    private String week;

    private String classRoom;

    private Integer pointA;

    private Integer pointB;

    private Integer pointC;

    private Integer pointD;

    private Integer finalPoint;

    public PointDTO() {
    }

    public PointDTO(Integer finalPoint) {
        this.finalPoint = finalPoint;
    }

    public PointDTO(Integer pointA, Integer pointB, Integer pointC, Integer pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    public PointDTO(String week, String classRoom, Integer pointA, Integer pointB, Integer pointC, Integer pointD) {
        this.week = week;
        this.classRoom = classRoom;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public PointDTO(Integer id, String week, Integer pointA, Integer pointB, Integer pointC, Integer pointD, Integer finalPoint) {
        this.id = id;
        this.week = week;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        this.finalPoint = finalPoint;
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

    public Integer getPointA() {
        return pointA;
    }

    public void setPointA(Integer pointA) {
        this.pointA = pointA;
    }

    public Integer getPointB() {
        return pointB;
    }

    public void setPointB(Integer pointB) {
        this.pointB = pointB;
    }

    public Integer getPointC() {
        return pointC;
    }

    public void setPointC(Integer pointC) {
        this.pointC = pointC;
    }

    public Integer getPointD() {
        return pointD;
    }

    public void setPointD(Integer pointD) {
        this.pointD = pointD;
    }

    public Integer getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(Integer finalPoint) {
        this.finalPoint = finalPoint;
    }
}
