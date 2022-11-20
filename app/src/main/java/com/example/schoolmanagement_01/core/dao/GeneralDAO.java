package com.example.schoolmanagement_01.core.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.schoolmanagement_01.core.DBHelper;
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
        Log.e("sql: ",sql);
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

    public void saveReport(String week,String classRoom, String ruleName
            ,String studentName,Integer minusPoint, String imageBitMap){

        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("week",week);
        values.put("class",classRoom);
        values.put("rule_name",ruleName);
        values.put("student_name",studentName);
        values.put("minus_point",minusPoint);
        values.put("path_image",imageBitMap);
        db.insert("report_tbl", null, values);
        db.close();
    }

    public Cursor findReportByWeekAndClass(String week, String classRoom){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM report_tbl as s where s.week = " + "'" + week +"' AND " +"s.class='"+classRoom+"'";
        Log.e("sql: ",sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
