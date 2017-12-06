package com.example.android.footyapp.network;

import android.net.Uri;
import android.util.Log;

import com.example.android.footyapp.models.Competition;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by globe_000 on 11/29/2017.
 */

public class Competitionutils extends NetworkUtils {

    public URL buildUrl(String code){
        Uri builtUri = Uri.parse(API_URL).buildUpon()
                .appendPath("v1")
                .appendPath("competitions")
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException mfe){
            mfe.printStackTrace();
        }
        return url;
    }


    public HashMap<String,Competition> getResponseFromJson(String response){
        HashMap<String, Competition> competitionMap = new HashMap<String,Competition>();
        try{
            JSONArray competitionArr = new JSONArray(response);
//            Log.d(TAG, competitionArr.toString());
            for(int j = 0; j < competitionArr.length(); j++){
                JSONObject jsonObj = competitionArr.getJSONObject(j);
                Log.d(TAG, jsonObj.toString());
                if( jsonObj.getString("league").equals("PL") || jsonObj.getString("league").equals("BL1") || jsonObj.getString("league").equals("SA")
                        || jsonObj.getString("league").equals("PD")) {
                    Log.d(TAG, "HERE");
                    Competition competition = new Competition(jsonObj.getString("id"), jsonObj.getString("caption"), jsonObj.getString("currentMatchday"),
                            jsonObj.getString("numberOfMatchdays"), jsonObj.getString("numberOfTeams"), jsonObj.getString("numberOfGames"), jsonObj.getString("league"));
                    competitionMap.put(jsonObj.getString("league"), competition);
                }

            }

        } catch( final JSONException je){
            Log.e(TAG, "JSON PARSING ERROR:" + je.getMessage());
        }
        return competitionMap;
    }
}
