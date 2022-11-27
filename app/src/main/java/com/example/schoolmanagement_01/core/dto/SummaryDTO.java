package com.example.schoolmanagement_01.core.dto;

public class SummaryDTO {

    private Integer id;

    private String classRoom;

    private Float diemXepLoaiTietHoc;

    private Integer diemThiDua;

    private Float diemTongKet;

    private Integer rank;

    public SummaryDTO(Integer id, String classRoom, Float diemXepLoaiTietHoc,Integer diemThiDua, Float diemTongKet, Integer rank) {
        this.id = id;
        this.classRoom = classRoom;
        this.diemXepLoaiTietHoc = diemXepLoaiTietHoc;
        this.diemThiDua = diemThiDua;
        this.diemTongKet = diemTongKet;
        this.rank = rank;
    }

    public SummaryDTO(String classRoom, Float diemXepLoaiTietHoc, Integer diemThiDua, Float diemTongKet) {
        this.classRoom = classRoom;
        this.diemXepLoaiTietHoc = diemXepLoaiTietHoc;
        this.diemThiDua = diemThiDua;
        this.diemTongKet = diemTongKet;
    }

    public SummaryDTO(String classRoom, Float diemXepLoaiTietHoc, Integer diemThiDua, Float diemTongKet, Integer rank) {
        this.classRoom = classRoom;
        this.diemXepLoaiTietHoc = diemXepLoaiTietHoc;
        this.diemThiDua = diemThiDua;
        this.diemTongKet = diemTongKet;
        this.rank = rank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public Float getDiemXepLoaiTietHoc() {
        return diemXepLoaiTietHoc;
    }

    public Integer getDiemThiDua() {
        return diemThiDua;
    }

    public void setDiemThiDua(Integer diemThiDua) {
        this.diemThiDua = diemThiDua;
    }

    public void setDiemXepLoaiTietHoc(Float diemXepLoaiTietHoc) {
        this.diemXepLoaiTietHoc = diemXepLoaiTietHoc;
    }

    public Float getDiemTongKet() {
        return diemTongKet;
    }

    public void setDiemTongKet(Float diemTongKet) {
        this.diemTongKet = diemTongKet;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
