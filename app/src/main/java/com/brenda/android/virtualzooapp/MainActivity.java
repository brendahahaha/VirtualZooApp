package com.brenda.android.virtualzooapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openArcticActivity(View view) {
        Intent intent = new Intent(this, ArcticActivity.class);
        startActivity(intent);

    }

    public void openOceanActivity(View view) {
        Intent intent = new Intent(this, OceanActivity.class);
        startActivity(intent);

    }
}
