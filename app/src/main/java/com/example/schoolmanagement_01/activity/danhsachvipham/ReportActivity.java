package com.example.schoolmanagement_01.activity.danhsachvipham;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.activity.danhsachvipham.adapter.ChooseClassRoomAdapter;
import com.example.schoolmanagement_01.activity.danhsachvipham.adapter.ChooseWeekAdapter;
import com.example.schoolmanagement_01.core.DBConstants;
import com.example.schoolmanagement_01.core.dao.GeneralDAO;

import java.util.ArrayList;
import java.util.List;

public class ReportActivity extends AppCompatActivity {
    GeneralDAO generalDAO;
    ReportAdapter reportAdapter;
    ChooseWeekAdapter chooseWeekAdapter;
    ChooseClassRoomAdapter chooseClassRoomAdapter;

    Spinner spnChooseWeek, spnChooseClassRoom;
    Button btnSearchReport;
    ListView lvReport;
    TextView tvNotify;


    List<String> listWeek = DBConstants.listWeek;
    List<String> listClassRoom = DBConstants.listClassRoom;

    String week= "";
    String positionWeek = "";
    String classRoom = "";
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        sharedPref = getSharedPreferences("week", MODE_PRIVATE);
        positionWeek = sharedPref.getString("position","2");
        week = listWeek.get(Integer.parseInt(positionWeek));
        Log.e("position",positionWeek);
        initView();
        action();
    }

    private void action() {
        btnSearchReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = generalDAO.findReportCursorByWeekAndClass(week,classRoom);
                if(cursor==null){
                    tvNotify.setVisibility(View.VISIBLE);
                }else {
                    tvNotify.setVisibility(View.GONE);
                }
                reportAdapter = new ReportAdapter(getApplicationContext(),cursor,true);
                lvReport.setAdapter(reportAdapter);
            }
        });
    }

    private void initView() {
        spnChooseClassRoom = findViewById(R.id.spn_choose_class_room);
        spnChooseWeek = findViewById(R.id.spn_choose_week);
        btnSearchReport = findViewById(R.id.btn_search_report);
        tvNotify = findViewById(R.id.tv_notify);
        lvReport = findViewById(R.id.lv_report);
        generalDAO = new GeneralDAO(getApplicationContext());


        chooseWeekAdapter = new ChooseWeekAdapter(getApplicationContext(), listWeek);
        spnChooseWeek.setAdapter(chooseWeekAdapter);
        spnChooseWeek.setSelection(Integer.parseInt(positionWeek));
        spnChooseWeek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                week = listWeek.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        chooseClassRoomAdapter = new ChooseClassRoomAdapter(getApplicationContext(), DBConstants.listClassRoom);
        spnChooseClassRoom.setAdapter(chooseClassRoomAdapter);
        spnChooseClassRoom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                classRoom = listClassRoom.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}