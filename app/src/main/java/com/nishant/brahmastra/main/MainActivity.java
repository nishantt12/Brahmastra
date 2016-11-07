package com.nishant.brahmastra.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nishant.com.brahmastra.Brahmastra;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Brahmastra.openPdf(this, "http://favouritetable.com/uploads/menu/635876883017774818.pdf", "Testing");

        Brahmastra.openPdfFragment(R.id.frame_layout, this, "http://favouritetable.com/uploads/menu/635876883017774818.pdf", true, true);



    }
}
