package com.example.android.footyapp.async;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by globe_000 on 12/10/2017.
 */

public class HttpImageRequestTask extends AsyncTask<String, Void, Drawable> {

    private ImageView imageView;

    public HttpImageRequestTask(ImageView imageView){
        this.imageView = imageView;
    }
    @Override
    protected Drawable doInBackground(String... params) {
        try {
            params[0] = params[0].replaceFirst("http:", "https:");
            final URL url = new URL(params[0]);
            Log.d("JAMESJIM", params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            SVG svg = SVGParser.getSVGFromInputStream(inputStream);
            Drawable drawable = svg.createPictureDrawable();
            return drawable;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Drawable drawable) {
        if(drawable != null){
            imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            imageView.setImageDrawable(drawable);
        }

    }
}
