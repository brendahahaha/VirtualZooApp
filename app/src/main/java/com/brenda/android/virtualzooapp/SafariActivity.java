package com.brenda.android.virtualzooapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SafariActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safari);

        ArrayList<String> safari = new ArrayList<>();
        safari.add("Cheetah");
        safari.add("Giraffe");
        safari.add("Lion");
        safari.add("Zebra");
        safari.add("Gazelle");
        safari.add("Rhino");

        ArrayList<Integer> safariImages = new ArrayList<>();
        safariImages.add(R.drawable.cheetah);
        safariImages.add(R.drawable.giraffe);
        safariImages.add(R.drawable.lion);
        safariImages.add(R.drawable.zebra);
        safariImages.add(R.drawable.gaz);
        safariImages.add(R.drawable.rhino);

        ArrayAdapter<String> itemsAdapter = new CustomAdapter(safari, safariImages, this);
        ListView listView = findViewById(R.id.safari_list);
        listView.setAdapter(itemsAdapter);

    }

    public class CustomAdapter extends ArrayAdapter<String> {

        ArrayList<String> safari = new ArrayList<>();
        ArrayList<Integer> safariImages;

        Context mContext;

        public CustomAdapter(ArrayList<String> safari, ArrayList<Integer> safariImages, Context context) {
            super(context, R.layout.safari_item, safari);
            this.mContext = context;
            this.safari = safari;
            this.safariImages = safariImages;

        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View view = inflater.inflate(R.layout.safari_item, parent, false);
            TextView textview = view.findViewById(R.id.safari_text);
            ImageView imageview = view.findViewById(R.id.safari_image);

            String item = safari.get(position);
            int image = safariImages.get(position);
            textview.setText(item);
            imageview.setImageResource(image);
            return view;
        }

    }
}
