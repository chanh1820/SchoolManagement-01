package com.example.schoolmanagement_01.activity.danhsachvipham;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.UltilService;

public class ReportAdapter extends CursorAdapter {
    public ReportAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_report,parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvName= view.findViewById(R.id.tv_student_name_report);
        TextView tvRule= view.findViewById(R.id.tv_rule_name_report);
        TextView tvCreatedDate= view.findViewById(R.id.tv_created_date);
        ImageView imvImage= view.findViewById(R.id.imv_image_report);
        LinearLayout linearLayout = view.findViewById(R.id.ln_item_report);
        if(cursor == null){
            tvName.setText("không có học sinh vi phạm");
        }
        if(cursor.getPosition()%2==0){
            linearLayout.setBackgroundColor(Color.parseColor("#84ffff"));
        }else {
            linearLayout.setBackgroundColor(Color.parseColor("#fafafa"));
        }
        tvName.setText(cursor.getString(5));
        tvRule.setText("("+cursor.getInt(6)+") "+cursor.getString(3));
        if(cursor.getString(8)==null|| cursor.getString(8).isEmpty() || cursor.getString(8).equals("")){
        }else{
            tvCreatedDate.setText(cursor.getString(8));
        }
        if((cursor.getString(7)==null|| cursor.getString(7).isEmpty() || cursor.getString(7).equals(""))){
            imvImage.setVisibility(View.GONE);
        }else {
            imvImage.setImageBitmap(UltilService.StringToBitMap(cursor.getString(7)));
        }

    }
}
