package com.geekbrain.android1.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CitiesFragment citiesFragment = new CitiesFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, citiesFragment)
                .commit();

        /*//standard interface
        MyConfiguration myConfiguration = new MyConfiguration();
        myConfiguration.color = "red";
        myConfiguration.height = 100;
        myConfiguration.length = 200;

        //Fluent interface

        IConfigurationFluent iConfigurationFluent = new ConfigurationFluent()
                .SetColor("black")
                .SetHeight(300)
                .SetLength(400);*/



    }
}

interface IConfiguration {
    String getColor();

    int getHeight();

    int getLength();
}

class MyConfiguration implements IConfiguration {
    String color;
    int height;
    int length;

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getLength() {
        return length;
    }
}


interface IConfigurationFluent {
    IConfigurationFluent SetColor(String color);

    IConfigurationFluent SetHeight(int height);

    IConfigurationFluent SetLength(int length);
}

class ConfigurationFluent implements IConfigurationFluent {
    String color;
    int height;
    int length;

    @Override
    public IConfigurationFluent SetColor(String color) {
            this.color= color;
            return this;

    }

    @Override
    public IConfigurationFluent SetHeight(int height) {
        this.height = height;
        return this;
    }

    @Override
    public IConfigurationFluent SetLength(int length) {
        this.length = length;
        return this;
    }
}