package com.example.schoolmanagement_01.activity.quanlytrucnhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.schoolmanagement_01.R;

public class AddReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_report);
        Intent i = getIntent();
        String className =  i.getStringExtra("class");
        
    }
}