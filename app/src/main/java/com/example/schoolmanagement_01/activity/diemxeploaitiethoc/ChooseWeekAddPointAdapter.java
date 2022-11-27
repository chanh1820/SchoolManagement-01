package com.example.schoolmanagement_01.activity.diemxeploaitiethoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.schoolmanagement_01.R;
import com.example.schoolmanagement_01.core.dto.ClassRoomDTO;
import com.example.schoolmanagement_01.core.dto.RuleDTO;

import java.util.List;

public class ChooseWeekAddPointAdapter extends BaseAdapter {
    private Context context;
    private List<String> listWeek;

    public ChooseWeekAddPointAdapter(Context context, List<String> listWeek) {
        this.context = context;
        this.listWeek = listWeek;
    }

    @Override
    public int getCount() {
        return listWeek != null ? listWeek.size() : 0;
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
        txtName.setText(listWeek.get(i));

        return rootView;
    }
}
