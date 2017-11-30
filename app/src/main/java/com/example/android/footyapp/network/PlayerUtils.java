package com.example.android.footyapp.network;

import android.net.Uri;
import android.util.Log;

import com.example.android.footyapp.models.Player;

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


    public ArrayList<HashMap<String,Player>> getResponseFromJson(String response){

        ArrayList<HashMap<String,Player>> list = new ArrayList<HashMap<String, Player>>();
        try{
            JSONObject jsonObj = new JSONObject(response);
            JSONArray players = jsonObj.getJSONArray("players");
            for(int j = 0; j < players.length(); j++){
                HashMap<String, Player> competitionMap = new HashMap<String,Player>();
                JSONObject row = players.getJSONObject(j);
                Player player = new Player(row.getString("name"),row.getString("position"),row.getString("jerseyNumber"),
                                          row.getString("dateOfBirth"),row.getString("nationality"),row.getString("contractUntil"));
                competitionMap.put("player",player);
                list.add(j, competitionMap);
            }

        } catch( final JSONException je){
            Log.e(TAG, "JSON PARSING ERROR:" + je.getMessage());
        }
        return list;
    }
}
