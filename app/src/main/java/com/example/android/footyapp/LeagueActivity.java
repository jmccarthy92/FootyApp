package com.example.android.footyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LeagueActivity extends AppCompatActivity implements LeagueFragment.OnFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
    }


}
