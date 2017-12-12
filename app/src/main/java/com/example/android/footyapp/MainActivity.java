package com.example.android.footyapp;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.footyapp.models.Competition;
import com.example.android.footyapp.network.Competitionutils;

import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CompetitionFragment.OnFragmentInteractionListener,
                                                                    FavoriteTeamFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

//        FragmentManager fManager = getFragmentManager();
//        if(getFragmentManager().findFragmentById(R.id.favoriteTeam) == null){
//            FragmentTransaction transaction = fManager.beginTransaction();
//            FavoriteTeamFragment fragment = new FavoriteTeamFragment();
//            transaction.add(R.id.favoriteTeam, fragment);
//            transaction.commit();
//        }
    }





}
