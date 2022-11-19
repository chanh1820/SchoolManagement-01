package com.example.schoolmanagement_01.activity.quanlytrucnhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.DBConstants;
import com.example.schoolmanagement_01.core.dto.ClassRoomDTO;

import java.util.ArrayList;

public class ChooseClassActivity extends AppCompatActivity {
    ListView lvChooseClass;
    ArrayList<ClassRoomDTO> classRoomDTOS = DBConstants.classRoomDTOS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_class);
        initView();
        action();
    }

    private void initView() {
        lvChooseClass = findViewById(R.id.lv_choose_class_room);
        ChooseClassAdapter arrayAdapter
                = new ChooseClassAdapter(getApplicationContext(), 0,classRoomDTOS);
        lvChooseClass.setAdapter(arrayAdapter);
    }
    private void action() {
        lvChooseClass.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ChooseClassActivity.this,AddReportActivity.class);
                intent.putExtra("class",classRoomDTOS.get(i).getClassName());
                startActivity(intent);
            }
        });
    }
}