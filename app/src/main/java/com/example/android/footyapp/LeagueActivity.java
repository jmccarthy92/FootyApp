package com.example.android.footyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LeagueActivity extends AppCompatActivity implements LeagueFragment.OnFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);
    }
}
