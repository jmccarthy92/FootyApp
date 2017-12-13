package com.example.android.footyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class TeamActivity extends AppCompatActivity implements TeamFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
    }

//    Had to override onOptions to have the back button reload the league intent with its data.
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(this,LeagueActivity.class);
                Bundle extras = this.getIntent().getExtras();
                intent.putExtra("URL_CODE",extras.getString("URL_CODE"));
                this.startActivity(intent);
                break;

        }
        return true;
    }
}
