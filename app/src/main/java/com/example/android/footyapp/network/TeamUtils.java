package com.example.android.footyapp.network;

import android.net.Uri;
import android.util.Log;

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


    public HashMap<String,String> getResponseFromJson(String response, String team){

       HashMap<String,String> competitionMap = new HashMap<String, String>();
        try{
            JSONObject jsonObj = new JSONObject(response);
            JSONArray standings = jsonObj.getJSONArray("standing");
            for(int j = 0; j < standings.length(); j++){

                JSONObject row = standings.getJSONObject(j);
                if( row.getString("teamName") == team) {
                    competitionMap.put("teamName", row.getString("teamName"));
                    competitionMap.put("crestURI", row.getString("crestURI"));
                    competitionMap.put("playedGames", row.getString("playedGames"));
                    competitionMap.put("points", row.getString("points"));
                    competitionMap.put("wins", row.getString("wins"));
                    competitionMap.put("draws", row.getString("draws"));
                    competitionMap.put("losses", row.getString("losses"));
                    competitionMap.put("goals", row.getString("goals"));
                    competitionMap.put("goalsAgainst", row.getString("goalsAgainst"));
                    competitionMap.put("goalDifference", row.getString("goalDifference"));
                    competitionMap.put("position", row.getString("position"));
                    JSONObject homeObj = row.getJSONObject("home");
                    competitionMap.put("homeGoals", homeObj.getString("goals"));
                    competitionMap.put("homeGoalsAgainst", homeObj.getString("goalsAgainst"));
                    competitionMap.put("homeWins", homeObj.getString("wins"));
                    competitionMap.put("homeDraws", homeObj.getString("draws"));
                    competitionMap.put("homeLosses", homeObj.getString("losses"));
                    JSONObject awayObj = row.getJSONObject("away");
                    competitionMap.put("awayGoals", awayObj.getString("goals"));
                    competitionMap.put("awayGoalsAgainst", awayObj.getString("goalsAgainst"));
                    competitionMap.put("awayWins", awayObj.getString("wins"));
                    competitionMap.put("awayDraws", awayObj.getString("draws"));
                    competitionMap.put("awayLosses", awayObj.getString("losses"));
                }

            }

        } catch( final JSONException je){
            Log.e(TAG, "JSON PARSING ERROR:" + je.getMessage());
        }
        return competitionMap;
    }

}
