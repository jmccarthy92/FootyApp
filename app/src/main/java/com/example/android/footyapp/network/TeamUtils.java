package com.example.android.footyapp.network;

import android.net.Uri;
import android.util.Log;

import com.example.android.footyapp.models.Team;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by globe_000 on 11/28/2017.
 */

public class TeamUtils extends NetworkUtils {

    public  URL buildUrl(String code){
        Uri builtUri = Uri.parse(API_URL).buildUpon()
                .appendPath("v1")
                .appendPath("competitions")
                .appendPath(code)
                .appendPath("leagueTable")
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException mfe){
            mfe.printStackTrace();
        }
        return url;
    }


    public HashMap<String,Team> getResponseFromJson(String response, String team){

       HashMap<String,Team> competitionMap = new HashMap<String, Team>();
        try{
            JSONObject jsonObj = new JSONObject(response);
            JSONArray standings = jsonObj.getJSONArray("standing");
            for(int j = 0; j < standings.length(); j++){

                JSONObject row = standings.getJSONObject(j);
                if( row.getString("teamName") == team) {

                    JSONObject homeObj = row.getJSONObject("home");
                    JSONObject awayObj = row.getJSONObject("away");
                    Team teamObj = new Team(row.getString("teamName"), row.getString("crestURI"),  row.getString("playedGames"), row.getString("points"),  row.getString("wins"),
                            row.getString("draws"),row.getString("losses"),row.getString("goals"),row.getString("goalsAgainst"),
                            row.getString("goalDifference"),row.getString("position"), homeObj.getString("goals"),homeObj.getString("goalsAgainst"),
                            homeObj.getString("wins"),homeObj.getString("draws"),homeObj.getString("losses"),awayObj.getString("goals"),
                            awayObj.getString("goalsAgainst"),awayObj.getString("wins"),awayObj.getString("draws"),awayObj.getString("losses"));

                    competitionMap.put("team", teamObj);

                }

            }

        } catch( final JSONException je){
            Log.e(TAG, "JSON PARSING ERROR:" + je.getMessage());
        }
        return competitionMap;
    }

}
