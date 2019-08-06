package com.example.viewmodelandlivedataexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragControl) != null){

            if(savedInstanceState != null)
            {
                return;
            }

            ControlFragment controlFragment = new ControlFragment();
            DetailFragment detailFragment = new DetailFragment();
            SummaryFragment summaryFragment = new SummaryFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragControl,controlFragment)
                    .add(R.id.fragDetails,detailFragment)
                    .add(R.id.fragSummary, summaryFragment)
                    .commit();
        }
    }
}
