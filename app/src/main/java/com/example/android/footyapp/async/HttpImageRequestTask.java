package com.example.android.footyapp.async;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.android.footyapp.helper.ImageResourceWorker;
import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by globe_000 on 12/10/2017.
 */
// Class used to Query the image returned by the football-data API and display it in the ImageView passed in
public class HttpImageRequestTask extends AsyncTask<String, Void, Drawable> {

    private ImageView imageView;

    public HttpImageRequestTask(ImageView imageView){
        this.imageView = imageView;
    }
    @Override
    protected Drawable doInBackground(String... params) {
        try {

            params[0] = params[0].replaceFirst("http:", "https:");
            if(params[0].contains(".png")){
                return getDrawableFrom_png_Drawable(params[0]);
            } else {
                final URL url = new URL(params[0]);
                Log.d("JAMESJIM", params[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                SVG svg = SVGParser.getSVGFromInputStream(inputStream);
                Drawable drawable = svg.createPictureDrawable();
                return drawable;
            }
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

    // If the file ends in .png run a different inputStream to decode it into a Drawable
    protected Drawable getDrawableFrom_png_Drawable(String url) throws IOException {
        Bitmap x;
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.connect();
        InputStream input = connection.getInputStream();
        x = BitmapFactory.decodeStream(input);
        return new BitmapDrawable(x);
    }
}
