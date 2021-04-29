package com.example.cnts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class DonnerAdapter extends ArrayAdapter<Donner> {
    private Context context;
    public DonnerAdapter(Context context, ArrayList<Donner> donners) {
        super(context, 0, donners);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.donner, parent, false);

        Donner donner = getItem(position);
        TextView name = (TextView) rowView.findViewById(R.id.donnerName);
        TextView bloodType = (TextView) rowView.findViewById(R.id.bloodType);
        TextView date = (TextView) rowView.findViewById(R.id.date);
        TextView donnated = (TextView) rowView.findViewById(R.id.donnated);

        name.setText(donner.getName());
        bloodType.setText(donner.getBloodType());
        date.setText(donner.getCreationDate());
        donnated.setText(donner.getDonated().toString());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rowView.getContext(), Profile.class);
                Bundle b = new Bundle();
                b.putString("uid", donner.getUid());
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
