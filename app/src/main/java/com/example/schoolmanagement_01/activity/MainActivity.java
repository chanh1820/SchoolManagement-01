package com.example.schoolmanagement_01.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.activity.danhsachvipham.ReportActivity;
import com.example.schoolmanagement_01.activity.quanlytrucnhat.ChooseClassActivity;
import com.example.schoolmanagement_01.core.DBHelper;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btnQuanLyTrucNhat, btnDanhSachViPham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        action();
    }

    private void action() {
        btnQuanLyTrucNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ChooseClassActivity.class);
                startActivity(i);
            }
        });
        btnDanhSachViPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ReportActivity.class);
                startActivity(i);
            }
        });
    }

    private void initView() {
        DBHelper db = new DBHelper(this);
        try {
            db.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        btnQuanLyTrucNhat = findViewById(R.id.btn_quan_ly_truc_nhat);
        btnDanhSachViPham = findViewById(R.id.btn_danh_sach_vi_pham);

    }
}