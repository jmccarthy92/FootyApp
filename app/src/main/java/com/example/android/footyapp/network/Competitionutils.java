package com.example.android.footyapp.network;

import android.net.Uri;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by globe_000 on 11/29/2017.
 */

public class Competitionutils extends NetworkUtils {

    private static final String API_URL = "http://api.football-data.org";


    public URL buildUrl(String code){
        Uri builtUri = Uri.parse(API_URL).buildUpon()
                .appendPath("v1")
                .appendPath("competitions")
                .appendPath(code)
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException mfe){
            mfe.printStackTrace();
        }
        return url;
    }


    public HashMap<String,String> getResponseFromJson(String response){
        HashMap<String, String> competitionMap = new HashMap<String,String>();
        try{
            JSONObject jsonObj = new JSONObject(response);
            competitionMap.put("id",jsonObj.getString("id"));
            competitionMap.put("league", jsonObj.getString("caption"));
            competitionMap.put("currentMatchday", jsonObj.getString("currentMatchday"));
            competitionMap.put("numberOfMatchdays", jsonObj.getString("numberOfMatchdays"));
            competitionMap.put("numberOfTeams", jsonObj.getString("numberOfTeams"));
            competitionMap.put("numberOfGames", jsonObj.getString("numberOfGames"));


        } catch( final JSONException je){
            Log.e(TAG, "JSON PARSING ERROR:" + je.getMessage());
        }
        return competitionMap;
    }
}
