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
 * Created by globe_000 on 11/29/2017.
 */

public class FixturesUtils extends NetworkUtils {

    public URL buildUrl(String code){
        Uri builtUri = Uri.parse(API_URL).buildUpon()
                .appendPath("v1")
                .appendPath("teams")
                .appendPath(code)
                .appendPath("fixtures")
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
            JSONArray fixtures = jsonObj.getJSONArray("fixtures");
            for(int j = 0; j < fixtures.length(); j++){
                HashMap<String, String> competitionMap = new HashMap<String,String>();
                JSONObject row = fixtures.getJSONObject(j);
                competitionMap.put("date",row.getString("date"));
                competitionMap.put("status",row.getString("status"));
                competitionMap.put("matchday",row.getString("matchday"));
                competitionMap.put("homeTeamName",row.getString("homeTeamName"));
                competitionMap.put("awayTeamName",row.getString("awayTeamName"));
                JSONObject result = row.getJSONObject("result");
                competitionMap.put("goalsHomeTeam",result.getString("goalsHomeTeam"));
                competitionMap.put("goalsAwayTeam",result.getString("goalsAwayTeam"));
         list.add(j, competitionMap);
            }

        } catch( final JSONException je){
            Log.e(TAG, "JSON PARSING ERROR:" + je.getMessage());
        }
        return list;
    }
}
