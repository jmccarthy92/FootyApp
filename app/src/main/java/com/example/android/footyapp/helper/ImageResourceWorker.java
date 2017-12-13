package com.example.android.footyapp.helper;

import android.util.Log;
import android.widget.ImageView;

import com.example.android.footyapp.R;

/**
 * Created by globe_000 on 12/10/2017.
 */

//Loading images from the URL was allocating to many resources and causing bugs.
    // This class is used to load in images that were too big or had issues loading.
public class ImageResourceWorker {

    public static boolean isBrokenSVG_Crest(String url){

        if( url.contains("Manchester_City_FC")){
            return true;
        } else if (url.contains("Manchester_United")){
            return true;
        } else if (url.contains("Liverpool")){
            return true;
        } else if (url.contains("Newcastle_United")){
            return true;
        } else if (url.contains("Swansea")){
            return true;
        } else if (url.contains("Watford")){
            return true;
        } else if (url.contains("Huddersfield")){
            return true;
        } else if( url.contains("West_Bromwich")){
            return true;
        } else if (url.contains("Brighton")){
            return true;
        } else if (url.contains("Stoke")){
            return true;
        } else if (url.contains("Alaves")){
            return true;
        } else if (url.contains("FC_Bayern")){
            return true;
        } else if (url.contains("Bologna")){
            return true;
        } else if (url.contains("Deportivo_La")){
            return true;
        } else if (url.contains("Eintracht")){
            return true;
        } else if (url.contains("Freiburg")){
            return true;
        } else if (url.contains("Getafe")){
            return true;
        } else if (url.contains("Girona")){
            return true;
        } else if (url.contains("Hamburger")){
            return true;
        } else if (url.contains("Juventus")){
            return true;
        } else if (url.contains("FC_Cologne")){
            return true;
        } else if (url.contains("Leverkusen")){
            return true;
        } else if (url.contains("Mainz")){
            return true;
        } else if (url.contains("nchengladbach")){
            return true;
        } else if (url.contains("Napoli")){
            return true;
        } else if (url.contains("Real_Madrid")){
            return true;
        } else if (url.contains("RB_Leip")){
            return true;
        } else if (url.contains("Schalke")){
            return true;
        } else if (url.contains("Stuttgart")){
            return true;
        } else if (url.contains("Torino")){
            return true;
        } else if (url.contains("Villarreal")){
            return true;
        } else if (url.contains("Werder")){
            return true;
        } else if (url.contains("Wolfsburg")){
            return true;
        } else if (url.contains("Crotone")){
            return true;
        } else if (url.contains("null") ){
            return true;
        } else if (url.contains("Dortmund")){
            return true;
        } else if (url.contains("Hoffenheim")){
            return true;
        } else if (url.contains("HSV")){
            return true;
        } else if (url.contains("Hertha_BSC")){
            return true;
        } else if (url.contains("Las_Palmas")){
            return true;
        } else if (url.contains("laga.")){
            return true;
        } else if (url.contains("Eibar"))
            return true;
        else if (url.contains("Celta_Vigo"))
            return true;
        else if (url.contains("Valencia"))
            return true;
        else if (url.contains("Sevilla"))
            return true;
        else if (url.contains("Atletico"))
            return true;
        return false;
    }

    public static void renderCrestImage(ImageView imageView, String url){
        Log.d("JIMMY", "-" + url);
        if( url.contains("Manchester_City_FC")){
            imageView.setBackgroundResource(R.mipmap.man_city);
        } else if (url.contains("Manchester_United")){
            imageView.setBackgroundResource(R.mipmap.man_u);
        } else if (url.contains("Liverpool")){
            imageView.setBackgroundResource(R.mipmap.liverpool);
        } else if (url.contains("Newcastle_United")){
            imageView.setBackgroundResource(R.mipmap.newcastle);
        } else if (url.contains("Swansea")){
            imageView.setBackgroundResource(R.mipmap.swansea);
        } else if (url.contains("Watford")){
            imageView.setBackgroundResource(R.mipmap.watford);
        } else if (url.contains("Huddersfield")){
            imageView.setBackgroundResource(R.mipmap.huddersfield);
        } else if (url.contains("West_Bromwich")){
            imageView.setBackgroundResource(R.mipmap.westbrom);
        } else if (url.contains("Brighton")){
            imageView.setBackgroundResource(R.mipmap.brighton);
        } else if (url.contains("Stoke")){
            imageView.setBackgroundResource(R.mipmap.stoke);
        } else if (url.contains("Alaves")){
            imageView.setBackgroundResource(R.mipmap.alaves);
        } else if (url.contains("FC_Bayern")){
            imageView.setBackgroundResource(R.mipmap.bayern);
        } else if (url.contains("Bologna")){
            imageView.setBackgroundResource(R.mipmap.bologna);
        } else if (url.contains("Deportivo_La")){
            imageView.setBackgroundResource(R.mipmap.deportivo);
        } else if (url.contains("Eintracht")){
            imageView.setBackgroundResource(R.mipmap.eintracht);
        } else if (url.contains("Freiburg")){
            imageView.setBackgroundResource(R.mipmap.freiburg);
        } else if (url.contains("Getafe")){
            imageView.setBackgroundResource(R.mipmap.getafe);
        } else if (url.contains("Girona")){
            imageView.setBackgroundResource(R.mipmap.girona);
        } else if (url.contains("Hamburger")){
            imageView.setBackgroundResource(R.mipmap.hamburger);
        } else if (url.contains("Juventus")){
            imageView.setBackgroundResource(R.mipmap.juventus);
        } else if (url.contains("FC_Cologne")){
            imageView.setBackgroundResource(R.mipmap.koln);
        } else if (url.contains("Leverkusen")){
            imageView.setBackgroundResource(R.mipmap.leverkusen);
        } else if (url.contains("Mainz")){
            imageView.setBackgroundResource(R.mipmap.mainz);
        } else if (url.contains("nchengladbach")){
            imageView.setBackgroundResource(R.mipmap.monchengladbach);
        } else if (url.contains("Napoli")){
            imageView.setBackgroundResource(R.mipmap.napoli);
        } else if (url.contains("Real_Madrid")){
            imageView.setBackgroundResource(R.mipmap.real_madrid);
        } else if (url.contains("RB_Leip")){
            imageView.setBackgroundResource(R.mipmap.redbull_leip);
        } else if (url.contains("Schalke")){
            imageView.setBackgroundResource(R.mipmap.schalke);
        } else if (url.contains("Stuttgart")){
            imageView.setBackgroundResource(R.mipmap.stuttgart);
        } else if (url.contains("Torino")){
            imageView.setBackgroundResource(R.mipmap.torino);
        } else if (url.contains("Villarreal")){
            imageView.setBackgroundResource(R.mipmap.villareal);
        } else if (url.contains("Werder")){
            imageView.setBackgroundResource(R.mipmap.werder_bremen);
        } else if (url.contains("Wolfsburg")){
            imageView.setBackgroundResource(R.mipmap.wolfsburg);
        } else if (url.contains("Crotone")){
            imageView.setBackgroundResource(R.mipmap.crotone);
        } else if (url.contains("null")){
            imageView.setBackgroundResource(R.mipmap.spal);
        } else if (url.contains("Dortmund")){
            imageView.setBackgroundResource(R.mipmap.dortmund);
        } else if (url.contains("Hoffenheim")){
            imageView.setBackgroundResource(R.mipmap.hoffenheim);
        } else if (url.contains("HSV")){
            imageView.setBackgroundResource(R.mipmap.hamburger);
        } else if (url.contains("Hertha_BSC")){
            imageView.setBackgroundResource(R.mipmap.hertha);
        } else if (url.contains("Las_Palmas")){
            imageView.setBackgroundResource(R.mipmap.las_palmas);
        } else if (url.contains("laga.")){
            imageView.setBackgroundResource(R.mipmap.malaga);
        } else if (url.contains("Eibar"))
            imageView.setBackgroundResource(R.mipmap.eibar);
        else if (url.contains("Celta_Vigo"))
            imageView.setBackgroundResource(R.mipmap.celta);
        else if (url.contains("Valencia"))
            imageView.setBackgroundResource(R.mipmap.valencia);
        else if (url.contains("Sevilla"))
            imageView.setBackgroundResource(R.mipmap.sevilla);
        else if (url.contains("Atletico"))
            imageView.setBackgroundResource(R.mipmap.atletico);

    }
}
