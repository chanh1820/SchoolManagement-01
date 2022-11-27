package com.example.schoolmanagement_01.activity.diemxeploaitiethoc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.activity.danhsachvipham.adapter.ChooseClassRoomAdapter;
import com.example.schoolmanagement_01.core.DBConstants;
import com.example.schoolmanagement_01.core.UltilService;
import com.example.schoolmanagement_01.core.dao.GeneralDAO;
import com.example.schoolmanagement_01.core.dto.PointDTO;

import java.util.List;

public class AddPointActivity extends AppCompatActivity {
    Button btnSavePoint, btnDelete;
    Spinner spnChooseClassRoomAddPoint,spnChooseWeekAddPoint;
    EditText edtPointA, edtPointB, edtPointC, edtPointD;
    PointDTO pointDTO = new PointDTO();
    List<String> listWeek = DBConstants.listWeek;
    List<String> listClassRoom = DBConstants.listClassRoom;
    GeneralDAO generalDAO ;
    ChooseWeekAddPointAdapter chooseWeekAddPointAdapter;
    ChooseClassRoomAdapter chooseClassRoomAdapter;
    SharedPreferences sharedPreferences;
    String position = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_point);
        sharedPreferences = getSharedPreferences("week",MODE_PRIVATE);
        position = sharedPreferences.getString("position", "0");
        intiView();
        action();
    }

    private void action() {
        btnSavePoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pointA = edtPointA.getText().toString().trim();
                String pointB = edtPointB.getText().toString().trim();
                String pointC = edtPointC.getText().toString().trim();
                String pointD = edtPointD.getText().toString().trim();
                pointDTO.setPointA(Integer.valueOf(pointA));
                pointDTO.setPointB(Integer.valueOf(pointB));
                pointDTO.setPointC(Integer.valueOf(pointC));
                pointDTO.setPointD(Integer.valueOf(pointD));
                if(UltilService.isNumeric(pointA)
                    && UltilService.isNumeric(pointB)
                    && UltilService.isNumeric(pointC)
                    && UltilService.isNumeric(pointD)){
                    Long respon = generalDAO.savePoint(pointDTO);
                    if(respon!=Long.valueOf(-1)){
                        Toast toast = Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_LONG);
                        toast.show();
                        finish();
                    }else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Lưu thất bại", Toast.LENGTH_LONG);
                        toast.show();                    }
                }else {
                    Log.e("ad", "xin moi nhap so");
                    Toast.makeText(getApplicationContext(), "Xin mời nhập số", Toast.LENGTH_LONG);
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("sa","as");
                generalDAO.clearPonintByWeekAndClass(pointDTO.getWeek(),pointDTO.getClassRoom());
            }
        });
    }

    private void intiView() {
        generalDAO = new GeneralDAO(getApplicationContext());
        btnSavePoint = findViewById(R.id.btn_save_point);
        spnChooseWeekAddPoint = findViewById(R.id.spn_choose_week_add_point);
        spnChooseClassRoomAddPoint = findViewById(R.id.spn_choose_class_room_add_point);
        edtPointA = findViewById(R.id.edt_point_a);
        edtPointB = findViewById(R.id.edt_point_b);
        edtPointC = findViewById(R.id.edt_point_C);
        edtPointD = findViewById(R.id.edt_point_d);
        btnDelete = findViewById(R.id.btn_clear_point_current);
        chooseWeekAddPointAdapter
                = new ChooseWeekAddPointAdapter(getApplicationContext(),listWeek);
        spnChooseWeekAddPoint.setAdapter(chooseWeekAddPointAdapter);
        spnChooseWeekAddPoint.setSelection(Integer.parseInt(position));
        spnChooseWeekAddPoint.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pointDTO.setWeek(listWeek.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        chooseClassRoomAdapter
                = new ChooseClassRoomAdapter(getApplicationContext(),listClassRoom);
        spnChooseClassRoomAddPoint.setAdapter(chooseClassRoomAdapter);
        spnChooseClassRoomAddPoint.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pointDTO.setClassRoom(listClassRoom.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}