package com.geekbrain.android1.lesson6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CitiesFragment citiesFragment = new CitiesFragment();

        if(savedInstanceState != null){
            currentPosition = savedInstanceState.getInt(CITY);
        }

       if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.coat_of_arms_container, CoatOfArmsFragment.newInstance(currentPosition))
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, citiesFragment)
                    .commit();
        }


    }

    private static final String CITY = "city";
    private int currentPosition = 0;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.getInt(CITY, currentPosition);
        super.onSaveInstanceState(outState);
    }
}

