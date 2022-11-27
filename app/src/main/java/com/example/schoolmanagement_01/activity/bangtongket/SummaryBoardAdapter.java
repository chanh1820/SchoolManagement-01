package com.example.schoolmanagement_01.activity.bangtongket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.dto.ClassRoomDTO;
import com.example.schoolmanagement_01.core.dto.SummaryDTO;

import java.util.ArrayList;
import java.util.List;

public class SummaryBoardAdapter extends ArrayAdapter<SummaryDTO> {


    public SummaryBoardAdapter(@NonNull Context context, int resource, @NonNull ArrayList<SummaryDTO> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listview_summary, parent, false);
        }

        TextView tvClassRoom = convertView.findViewById(R.id.tv_class_room_summary);
        TextView tvDiemXepLoaiTietHoc = convertView.findViewById(R.id.tv_diem_xep_loai_tiet_hoc);
        TextView tvDiemThiDua = convertView.findViewById(R.id.tv_diem_thi_dua);
        TextView tvDiemTongKet = convertView.findViewById(R.id.tv_tong_ket);
        TextView tvRank = convertView.findViewById(R.id.tv_hang);

        SummaryDTO summaryDTO = getItem(position);
        tvClassRoom.setText(summaryDTO.getClassRoom());
        tvDiemXepLoaiTietHoc.setText(String.format("%.2f", summaryDTO.getDiemXepLoaiTietHoc()));
        tvDiemThiDua.setText(summaryDTO.getDiemThiDua()+"");
        tvDiemTongKet.setText(String.format("%.2f", summaryDTO.getDiemTongKet()));
        tvRank.setText(summaryDTO.getRank()+"");
        return convertView;
    }
}
