package com.nishant.brahmastra.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nishant.com.brahmastra.Brahmastra;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Brahmastra.openWeb(this, "http://www.google.com");

    }
}
