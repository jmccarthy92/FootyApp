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

public class PlayerUtils extends NetworkUtils {

    public URL buildUrl(String code){
        Uri builtUri = Uri.parse(API_URL).buildUpon()
                .appendPath("v1")
                .appendPath("teams")
                .appendPath(code)
                .appendPath("players")
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
            JSONArray players = jsonObj.getJSONArray("players");
            for(int j = 0; j < players.length(); j++){
                HashMap<String, String> competitionMap = new HashMap<String,String>();
                JSONObject row = players.getJSONObject(j);
                competitionMap.put("name",row.getString("name"));
                competitionMap.put("position",row.getString("position"));
                competitionMap.put("jerseyNumber",row.getString("jerseyNumber"));
                competitionMap.put("dateOfBirth",row.getString("dateOfBirth"));
                competitionMap.put("nationality",row.getString("nationality"));
                competitionMap.put("contractUntil",row.getString("contractUntil"));
                list.add(j, competitionMap);
            }

        } catch( final JSONException je){
            Log.e(TAG, "JSON PARSING ERROR:" + je.getMessage());
        }
        return list;
    }
}
