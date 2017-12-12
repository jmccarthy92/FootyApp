package com.example.android.footyapp.network;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by globe_000 on 11/28/2017.
 */

public abstract class NetworkUtils {

    protected static final String API_KEY = "ceb26da2cb3f4f3ba5da6036c44325b3";
    protected static final String TAG = "JAMES";
    protected static final String API_URL = "http://api.football-data.org";

    public String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestProperty("X-Auth-Token", API_KEY);
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            String response = convertStreamToString(in);
            if( response != null)
                return response;
            else
                return null;
        } finally {
            urlConnection.disconnect();
        }
    }

    public String convertStreamToString(InputStream is) {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while((line = br.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return sb.toString();
    }

    public abstract URL buildUrl(String code);


}
