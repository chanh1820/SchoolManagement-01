package com.example.schoolmanagement_01.core.dto;

public class StudentDTO {
    private Integer id;

    private String studentName;

    private String classRoom;

    public StudentDTO(Integer id, String studentName, String classRoom) {
        this.id = id;
        this.studentName = studentName;
        this.classRoom = classRoom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
}
