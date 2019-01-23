package com.dissert.cs.buttonshowhide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> {

    TextView txtName;
    TextView txtPath;


    public CustomAdapter(Context context, ArrayList<String> filePaths) {
        super(context, R.layout.custom_row, filePaths);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_row, parent, false);

        String singleItem = getItem(position);
        txtName = customView.findViewById(R.id.txtName);

        txtName.setText(singleItem);
        return customView;
    }
}
