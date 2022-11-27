package com.example.schoolmanagement_01.activity.bangtongket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.schoolmanagement_01.BuildConfig;
import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.DBConstants;
import com.example.schoolmanagement_01.core.UltilService;
import com.example.schoolmanagement_01.core.dao.GeneralDAO;
import com.example.schoolmanagement_01.core.dto.PointDTO;
import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.dto.SummaryDTO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class SummaryBoardActivity extends AppCompatActivity {
    ListView lvSummary;
    TextView tvStaffName, tvWeek;
    Button btnSaveScreenShot;
    ArrayList<SummaryDTO> summaryDTOList;

    GeneralDAO generalDAO;
    SummaryBoardAdapter summaryBoardAdapter;
    List<String> listSessionClass ;
    String week = "0";
    String staffName = "";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_board);
        Intent intent = getIntent();
        Integer session = intent.getIntExtra("session",0);
        Log.e("session",session.toString());
        switch (session){
            case 0:
                listSessionClass = DBConstants.listClassSang;
                break;
            case 1:
                listSessionClass = DBConstants.listClassChieu;
                break;
        }
        lvSummary = findViewById(R.id.lvSummary);
        tvStaffName = findViewById(R.id.tv_summary_staff_name);
        tvWeek = findViewById(R.id.tv_summary_week);
        btnSaveScreenShot = findViewById(R.id.btnSaveScreenShot);
        ActivityCompat.requestPermissions(SummaryBoardActivity.this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE},
                PackageManager.PERMISSION_GRANTED);
        btnSaveScreenShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeScreenshot(view, "result");
            }
        });
        generalDAO = new GeneralDAO(getApplicationContext());
        summaryDTOList = new ArrayList<SummaryDTO>();
        sharedPreferences = getSharedPreferences("week",MODE_PRIVATE);
        week = sharedPreferences.getString("week",0+"");
        staffName = sharedPreferences.getString("staff_name",0+"");
        tvWeek.setText("Tuần: "+ week);
        tvStaffName.setText("Người trực: "+staffName);
        float [] arr = new float[8];
        int position = 0;
        for (String classRoom: listSessionClass){
            PointDTO pointDTO = generalDAO.findPointByWeekAndClass(week, classRoom);
            List<ReportDTO> reportDTOList = generalDAO.findReportByWeekAndClass(week,classRoom);
            Float diemXepLoaitietHoc = UltilService.calculatorDiemXepLoaiTietHoc(pointDTO);
            Integer diemThiDua = UltilService.calculatorDiemThiDuaForClass(reportDTOList);
            Float diemTongKet = diemXepLoaitietHoc + diemThiDua;
            summaryDTOList.add(new SummaryDTO(classRoom, diemXepLoaitietHoc, diemThiDua, diemTongKet));
            arr[position] = diemTongKet;
            position++;
        }
        float[] temp = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(temp);
        UltilService.reverseArrayFloat(temp);
        HashMap<Float, Integer> map = new HashMap<>();
        int index = 1;
        float prev = temp[0];
        map.put(prev, index);

        for(int i = 1; i<arr.length; i++){
            if(prev!=temp[i])
                index++;
            map.put(temp[i], index);
            prev=temp[i];
        }

        for(int i=0; i<arr.length; i++){
            summaryDTOList.get(i).setRank(map.get(arr[i]));
        }
        summaryBoardAdapter = new SummaryBoardAdapter(getApplicationContext(),0, summaryDTOList);
        lvSummary.setAdapter(summaryBoardAdapter);
    }
    private void takeScreenshot(View view , String fileName) {
        Date now = new Date();
        CharSequence format = DateFormat.format("yyyy-MM-dd_hh:mm:ss",now);

        try {
//            // image naming and path  to include sd card  appending name you choose for file
            ContextWrapper cw = new ContextWrapper(getApplicationContext());
            String fullPath =cw.getExternalFilesDir(Environment.DIRECTORY_MUSIC).toString();
//            String mPath = getApplicationContext().get.getExternalFilesDir(Environment.DIRECTORY_DCIM) + "/" + now + ".jpg";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1) {
                fullPath= SummaryBoardActivity.this.getExternalFilesDir
                        (Environment.DIRECTORY_DCIM).toString();
            }
            else
            {
                fullPath = Environment.getExternalStorageDirectory()
                        .toString();
            }

//            String dirPath =Environment.getExternalStorageDirectory().toString()+"/chanh";
            File fileDir = new File(fullPath);
            if(!fileDir.exists()){
                boolean mkdir = fileDir.mkdir();
            }

            String path = fullPath+"/"+ fileName +"-"+format +"jpeg";
            // create bitmap screen capture
            View v1 = view;
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);

            File imageFile  = new File(path);
            FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
//            v1.setDrawingCacheEnabled(false);
//
//            File imageFile = new File(fullPath);
//
//            FileOutputStream outputStream = new FileOutputStream(imageFile);
//            int quality = 100;
//            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
//            outputStream.flush();
//            outputStream.close();

//            openScreenshot(imageFile);
        } catch (Throwable e) {
            // Several error may come out with file handling or DOM
            e.printStackTrace();
        }
    }
    private void openScreenshot(File imageFile) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = FileProvider.getUriForFile(SummaryBoardActivity.this, BuildConfig.APPLICATION_ID + ".provider",imageFile);
        intent.setDataAndType(uri, "image/*");
        startActivity(intent);
    }

    public  Bitmap getBitmapFromView(View view) {
        android.graphics.Bitmap bitmap =
                android.graphics.Bitmap.createBitmap(view.getWidth(), view.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }
    public static Bitmap loadBitmapFromView(Context context, View v) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        v.measure(View.MeasureSpec.makeMeasureSpec(dm.widthPixels, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(dm.heightPixels, View.MeasureSpec.EXACTLY));
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
        Bitmap returnedBitmap = Bitmap.createBitmap(v.getMeasuredWidth(),
                v.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(returnedBitmap);
        v.draw(c);

        return returnedBitmap;
    }
}