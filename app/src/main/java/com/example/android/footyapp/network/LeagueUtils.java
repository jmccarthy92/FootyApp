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


    public ArrayList<HashMap<String,String>> getResponseFromJson(String response){

        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try{
            JSONObject jsonObj = new JSONObject(response);
            JSONArray standings = jsonObj.getJSONArray("standing");
            for(int j = 0; j < standings.length(); j++){
                HashMap<String, String> competitionMap = new HashMap<String,String>();
                JSONObject row = standings.getJSONObject(j);
                competitionMap.put("teamName",row.getString("teamName"));
                competitionMap.put("crestURI",row.getString("crestURI"));
                competitionMap.put("playedGames",row.getString("playedGames"));
                competitionMap.put("points",row.getString("points"));
                competitionMap.put("wins",row.getString("wins"));
                competitionMap.put("draws",row.getString("draws"));
                competitionMap.put("losses",row.getString("losses"));
                competitionMap.put("goals",row.getString("goals"));
                competitionMap.put("goalDifference",row.getString("goalDifference"));
                list.add(j, competitionMap);
            }

        } catch( final JSONException je){
            Log.e(TAG, "JSON PARSING ERROR:" + je.getMessage());
        }
        return list;
    }


}
