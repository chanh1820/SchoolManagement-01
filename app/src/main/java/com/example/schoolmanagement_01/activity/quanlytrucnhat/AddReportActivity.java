package com.example.schoolmanagement_01.activity.quanlytrucnhat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.activity.quanlytrucnhat.adapter.ChooseRuleChildAdapter;
import com.example.schoolmanagement_01.activity.quanlytrucnhat.adapter.ChooseRuleParentAdapter;
import com.example.schoolmanagement_01.activity.quanlytrucnhat.adapter.ChooseStudentAdapter;
import com.example.schoolmanagement_01.core.DBConstants;
import com.example.schoolmanagement_01.core.UltilService;
import com.example.schoolmanagement_01.core.dao.GeneralDAO;
import com.example.schoolmanagement_01.core.dto.RuleDTO;
import com.example.schoolmanagement_01.core.dto.StudentDTO;



import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;



public class AddReportActivity extends AppCompatActivity {
    Spinner studentSpinner;
    Spinner chooseRuleParentSpinner;
    Spinner chooseRuleChildSpinner;
    ImageView imvInitImage;
    Button btnSaveReport;
    private static final int CAMERA_REQUEST_CODE = 100;
    List<StudentDTO> studentDTOList = new ArrayList<>();
    List<RuleDTO> ruleDTOList = DBConstants.listRuleDTO;
    List<RuleDTO> ruleParentList = UltilService.getRules(ruleDTOList,0);
    List<RuleDTO> ruleChildList = new ArrayList<>();

    ChooseStudentAdapter chooseStudentAdapter;
    ChooseRuleParentAdapter chooseRuleParentAdapter;
    ChooseRuleChildAdapter chooseRuleChildAdapter;
    GeneralDAO generalDAO;

    String className = "";
    String studentName = "";
    String ruleChild = "";
    Integer minusPoint = 0;
    String imageBitmap="";
    String weekCurrent = "20";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_report);
        initView();
        action();

    }

    private void action() {
        imvInitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,CAMERA_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == CAMERA_REQUEST_CODE){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imvInitImage.setImageBitmap(bitmap);
                imageBitmap = UltilService.BitMapToString(bitmap);
            }
        }
    }

    private void initView() {
        studentSpinner = findViewById(R.id.spn_choose_student);
        chooseRuleChildSpinner = findViewById(R.id.spn_choose_rule_child);
        chooseRuleParentSpinner = findViewById(R.id.spn_choose_rule_parent);
        imvInitImage = findViewById(R.id.imv_init_image);
        btnSaveReport = findViewById(R.id.btn_save_report);

        ImageView imageView, imageView2;
        Button button = findViewById(R.id.btn_save_report);
        imageView = findViewById(R.id.imv_init_image);
        imageView2 = findViewById(R.id.imageView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("week",weekCurrent);
                Log.e("class",className);
                Log.e("ruleChild",ruleChild);
                Log.e("student",studentName);
                Log.e("minusPoint",minusPoint+" ");
                Log.e("imagebitmap","image bitmap");
                generalDAO.saveReport(weekCurrent,className,ruleChild, studentName,minusPoint, imageBitmap);

            }
        });


        Intent i = getIntent();
        className =  i.getStringExtra("class");
        generalDAO = new GeneralDAO(getApplicationContext());
        studentDTOList = generalDAO.findStudentByClassRoom(className);
        chooseStudentAdapter = new ChooseStudentAdapter(getApplicationContext(),studentDTOList);
        studentSpinner.setAdapter(chooseStudentAdapter);
        studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                studentName = studentDTOList.get(i).getStudentName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        chooseRuleParentAdapter = new ChooseRuleParentAdapter(getApplicationContext(), ruleParentList);
        chooseRuleParentSpinner.setAdapter(chooseRuleParentAdapter);
        chooseRuleParentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ruleChildList = UltilService.getRules(ruleDTOList,ruleParentList.get(i).getId());
                updateRuleChildSpinner(ruleChildList);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void updateRuleChildSpinner(List<RuleDTO> ruleChildList) {
        chooseRuleChildAdapter = new ChooseRuleChildAdapter(getApplicationContext(),ruleChildList);
        chooseRuleChildSpinner.setAdapter(chooseRuleChildAdapter);
        chooseRuleChildSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ruleChild = ruleChildList.get(i).getRuleName();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}