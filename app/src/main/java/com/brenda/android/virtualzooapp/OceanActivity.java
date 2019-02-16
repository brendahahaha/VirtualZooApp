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

public class OceanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocean);

        ArrayList<String> ocean = new ArrayList<>();
        ocean.add("Whales");
        ocean.add("Dolphins");
        ocean.add("Fish");
        ocean.add("Manta Ray");
        ocean.add("Octopus");
        ocean.add("Sharks");

        ArrayList<Integer> oceanImages = new ArrayList<>();
        oceanImages.add(R.drawable.whale);
        oceanImages.add(R.drawable.dolphin);
        oceanImages.add(R.drawable.fish);
        oceanImages.add(R.drawable.manta);
        oceanImages.add(R.drawable.octopus);
        oceanImages.add(R.drawable.shark);

        ArrayAdapter<String> itemsAdapter = new CustomAdapter(ocean, oceanImages, this);
        ListView listView = findViewById(R.id.ocean_list);
        listView.setAdapter(itemsAdapter);

    }

    public class CustomAdapter extends ArrayAdapter<String> {

        ArrayList<String> ocean = new ArrayList<>();
        ArrayList<Integer> oceanImages;

        Context mContext;

        public CustomAdapter(ArrayList<String> ocean, ArrayList<Integer> oceanImages, Context context) {
            super(context, R.layout.arctic_item, ocean);
            this.mContext = context;
            this.ocean = ocean;
            this.oceanImages = oceanImages;

        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View view = inflater.inflate(R.layout.ocean_item, parent, false);
            TextView textview = view.findViewById(R.id.ocean_text);
            ImageView imageview = view.findViewById(R.id.ocean_image);

            String item = ocean.get(position);
            int image = oceanImages.get(position);
            textview.setText(item);
            imageview.setImageResource(image);
            return view;
        }

    }
}
