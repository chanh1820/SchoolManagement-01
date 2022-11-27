package com.example.schoolmanagement_01.core.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.schoolmanagement_01.core.DBHelper;
import com.example.schoolmanagement_01.core.dto.PointDTO;
import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.dto.RuleDTO;
import com.example.schoolmanagement_01.core.dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public class GeneralDAO {

    DBHelper dbHelper;

    public GeneralDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public List<StudentDTO> findStudentByClassRoom(String classRoom) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM student_tbl as s where s.class_room = " + "'" + classRoom+ "'";
        Log.e("sql",sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        if (cursor.getCount() != 0) {
            do {
                StudentDTO item;
                item = new StudentDTO(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                );
                studentDTOList.add(item);
            } while (cursor.moveToNext());
        }
        return studentDTOList;
    }

    public void saveReport(ReportDTO reportDTO){

        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("week",reportDTO.getWeek());
        values.put("class",reportDTO.getClassRoom());
        values.put("rule_name",reportDTO.getRuleName());
        values.put("ruleId",reportDTO.getRuleId());
        values.put("student_name",reportDTO.getStudentName());
        values.put("minus_point",reportDTO.getMinusPoint());
        values.put("path_image",reportDTO.getPathImage());
        values.put("created_date",reportDTO.getCreatedDate());
        db.insert("report_tbl", null, values);
        db.close();
    }
    public Long savePoint(PointDTO pointDTO){
        PointDTO pointDTOExisting = findPointByWeekAndClass(pointDTO.getWeek(), pointDTO.getClassRoom());
        if (pointDTOExisting!=null){
            return Long.valueOf(-1);
        }
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("week",pointDTO.getWeek());
        values.put("class_room",pointDTO.getClassRoom());
        values.put("point_a",pointDTO.getPointA());
        values.put("point_b",pointDTO.getPointB());
        values.put("point_c",pointDTO.getPointC());
        values.put("point_d",pointDTO.getPointD());
        Long id = db.insert("point_tbl", null, values);
        db.close();
        return id;
    }

    public Cursor findReportCursorByWeekAndClass(String week, String classRoom){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM report_tbl as s where s.week = " + "'" + week +"' AND " +"s.class='"+classRoom+"'";
        Log.e("sql",sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public List<ReportDTO> findReportByWeekAndClass(String week, String classRoom){
        List<ReportDTO> reportDTOList = new ArrayList<>();
        Cursor cursor = findReportCursorByWeekAndClass(week,classRoom);
        if (cursor.getCount() != 0) {
            do {
                ReportDTO item;
                item = new ReportDTO(
                        cursor.getInt(4),
                        cursor.getInt(6)
                );
                reportDTOList.add(item);
            } while (cursor.moveToNext());
        }
        return reportDTOList;
    }
    public PointDTO findPointByWeekAndClass(String week, String classRoom){
        PointDTO item = new PointDTO();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM point_tbl as s where s.week = " + "'" + week +"' AND " +"s.class_room='"+classRoom+"'";
        Log.e("sql",sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }else {
            return null;
        }
        if (cursor.getCount() != 0) {
            do {
                item = new PointDTO(cursor.getInt(3),cursor.getInt(4), cursor.getInt(5), cursor.getInt(5));
                Log.e(cursor.getInt(3)+"", cursor.getInt(4)+"");
            } while (cursor.moveToNext());
        }else {
            return null;
        }
        return item;
    }

    public void clearPonintByWeekAndClass(String week, String classRoom) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "DELETE FROM point_tbl as s where s.week = " + "'" + week +"' AND " +"s.class_room='"+classRoom+"'";
        Log.e("sql",sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
    }
}

