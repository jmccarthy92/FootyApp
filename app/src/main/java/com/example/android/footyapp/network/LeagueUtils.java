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

    private String code;

    public URL buildUrl(String code){
        this.code = code;
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


    public ArrayList<League> getResponseFromJson(String response){

        ArrayList<League> list = new ArrayList<League>();
        try{
            JSONObject jsonObj = new JSONObject(response);
            JSONArray standings = jsonObj.getJSONArray("standing");
            for(int j = 0; j < standings.length(); j++){

                JSONObject row = standings.getJSONObject(j);
                League league = new League(row.getString("teamName"),row.getString("crestURI"),row.getString("playedGames"),
                                row.getString("points"),row.getString("wins"),row.getString("draws"),row.getString("losses"),
                                row.getString("goals"),row.getString("goalDifference"));
                league.setId(this.code);
                Log.d("JAMES",league.toString());
                list.add(j, league);
            }

        } catch( final JSONException je){
            Log.e(TAG, "JSON PARSING ERROR:" + je.getMessage());
        }
        return list;
    }


}
