package com.example.android.footyapp.network;

import android.net.Uri;
import android.util.Log;

import com.example.android.footyapp.models.Fixtures;

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


    public ArrayList<HashMap<String,Fixtures>> getResponseFromJson(String response){

        ArrayList<HashMap<String,Fixtures>> list = new ArrayList<HashMap<String, Fixtures>>();
        try{
            JSONObject jsonObj = new JSONObject(response);
            JSONArray fixtures = jsonObj.getJSONArray("fixtures");
            for(int j = 0; j < fixtures.length(); j++){
                HashMap<String, Fixtures> competitionMap = new HashMap<String,Fixtures>();
                JSONObject row = fixtures.getJSONObject(j);
                JSONObject result = row.getJSONObject("result");
                Fixtures fixturesObj = new Fixtures(row.getString("date"),row.getString("status"),row.getString("matchday"),
                                                    row.getString("homeTeamName"),row.getString("awayTeamName"),
                                                    result.getString("goalsHomeTeam"),result.getString("goalsAwayTeam"));
                competitionMap.put("fixtures",fixturesObj);
                list.add(j, competitionMap);
            }

        } catch( final JSONException je){
            Log.e(TAG, "JSON PARSING ERROR:" + je.getMessage());
        }
        return list;
    }
}
