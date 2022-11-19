package com.example.schoolmanagement_01.core.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.schoolmanagement_01.core.DBHelper;
import com.example.schoolmanagement_01.core.dto.RuleDTO;

import java.util.ArrayList;
import java.util.List;

public class GeneralDAO {

    DBHelper dbHelper;

    public GeneralDAO(Context context) {
        dbHelper = new DBHelper(context);
    }
    public List<RuleDTO> find(Integer classNumber, Integer unit, String partOfUnit) {
        List<RuleDTO> translateDTOList = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM translate as t where t.class = " + classNumber + " AND " + "t.unit =" + unit + " AND" + " +t.part_of_unit = " + "'" + partOfUnit + "'";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        if (cursor.getCount() != 0) {
            do {
                RuleDTO item;
                item = new RuleDTO(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2)
                );
                translateDTOList.add(item);
            } while (cursor.moveToNext());
        }

        return translateDTOList;
    }
}
