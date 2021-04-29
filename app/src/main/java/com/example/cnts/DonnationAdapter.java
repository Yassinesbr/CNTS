package com.example.cnts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DonnationAdapter extends ArrayAdapter<Donnation> {
    private Context context;
    public DonnationAdapter(Context context, ArrayList<Donnation> donnations) {
        super(context, 0, donnations);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.donation, parent, false);

        Donnation donnation = getItem(position);
        TextView center = (TextView) rowView.findViewById(R.id.centerDonation);
        TextView date = (TextView) rowView.findViewById(R.id.dateDonation);
        TextView time = (TextView) rowView.findViewById(R.id.timeDonnation);

        center.setText(donnation.getCenter());
        date.setText(donnation.getDate());
        time.setText(donnation.getTime());

        return rowView;
    }
}
