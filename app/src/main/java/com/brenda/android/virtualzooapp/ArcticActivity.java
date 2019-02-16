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

    public class ArcticActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_arctic);

            ArrayList<String> arctic = new ArrayList<>();
            arctic.add("Arctic Foxes");
            arctic.add("Seals");
            arctic.add("Polar Bears");
            arctic.add("Snow Hares");
            arctic.add("Walrus");
            arctic.add("Arctic wolves");

            ArrayList<Integer> arcticImages = new ArrayList<>();
            arcticImages.add(R.drawable.fox);
            arcticImages.add(R.drawable.seal);
            arcticImages.add(R.drawable.polar);
            arcticImages.add(R.drawable.hare);
            arcticImages.add(R.drawable.walrus);
            arcticImages.add(R.drawable.wolf);

            ArrayAdapter<String> itemsAdapter = new CustomAdapter(arctic, arcticImages, this);
            ListView listView = findViewById(R.id.arctic_list);
            listView.setAdapter(itemsAdapter);

        }

        public class CustomAdapter extends ArrayAdapter<String> {

            ArrayList<String> arctic = new ArrayList<>();
            ArrayList<Integer> arcticImages;

            Context mContext;

            public CustomAdapter(ArrayList<String> arctic, ArrayList<Integer> arcticImages, Context context) {
                super(context, R.layout.arctic_item, arctic);
                this.mContext = context;
                this.arctic = arctic;
                this.arcticImages = arcticImages;

            }

            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                View view = inflater.inflate(R.layout.arctic_item, parent, false);
                TextView textview = view.findViewById(R.id.arctic_text);
                ImageView imageview = view.findViewById(R.id.arctic_image);

                String item = arctic.get(position);
                int image = arcticImages.get(position);
                textview.setText(item);
                imageview.setImageResource(image);
                return view;
            }

        }
    }
