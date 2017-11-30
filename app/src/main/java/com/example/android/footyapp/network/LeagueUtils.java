package com.example.android.footyapp.network;

import android.net.Uri;
import android.util.Log;

import com.example.android.footyapp.models.League;

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

public class LeagueUtils extends NetworkUtils {

    public URL buildUrl(String code){
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


    public ArrayList<HashMap<String,League>> getResponseFromJson(String response){

        ArrayList<HashMap<String,League>> list = new ArrayList<HashMap<String, League>>();
        try{
            JSONObject jsonObj = new JSONObject(response);
            JSONArray standings = jsonObj.getJSONArray("standing");
            for(int j = 0; j < standings.length(); j++){
                HashMap<String, League> competitionMap = new HashMap<String,League>();
                JSONObject row = standings.getJSONObject(j);
                League league = new League(row.getString("teamName"),row.getString("crestURI"),row.getString("playedGames"),
                                row.getString("points"),row.getString("wins"),row.getString("draws"),row.getString("losses"),
                                row.getString("goals"),row.getString("goalDifference"));
                competitionMap.put("league",league);
                list.add(j, competitionMap);
            }

        } catch( final JSONException je){
            Log.e(TAG, "JSON PARSING ERROR:" + je.getMessage());
        }
        return list;
    }


}
