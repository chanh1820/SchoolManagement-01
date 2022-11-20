package com.example.schoolmanagement_01.activity.danhsachvipham.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.dto.RuleDTO;

import java.util.List;

public class ChooseClassRoomAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public ChooseClassRoomAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_spinner, viewGroup, false);

        TextView txtName = rootView.findViewById(R.id.tv_student_name);
        txtName.setText(list.get(i));

        return rootView;
    }
}
