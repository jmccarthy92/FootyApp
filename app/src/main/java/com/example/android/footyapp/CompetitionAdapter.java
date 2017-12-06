package com.example.android.footyapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.footyapp.models.Competition;

import java.util.ArrayList;

/**
 * Created by globe_000 on 12/6/2017.
 */

public class CompetitionAdapter extends ArrayAdapter<Competition> {

    private final Context context;
    private final ArrayList<Competition> competitionList;

    public CompetitionAdapter(Context context, ArrayList<Competition> competitionList){
        super(context, R.layout.competition_row, competitionList);
        this.context = context;
        this.competitionList = competitionList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.competition_row, parent, false);

        TextView caption = (TextView) rowView.findViewById(R.id.caption);
        TextView currentMatchDay = (TextView) rowView.findViewById(R.id.current_match_day);
        TextView numberOfMatches = (TextView) rowView.findViewById(R.id.number_of_matches);
        ImageView thumbnailImage = (ImageView) rowView.findViewById(R.id.league_image);
        RelativeLayout relativeLayout =(RelativeLayout) rowView.findViewById(R.id.comp_row);
        relativeLayout.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               Intent intent = new Intent(v.getContext(),LeagueActivity.class);
               v.getContext().startActivity(intent);
           }
        });

        caption.setText(competitionList.get(position).getLeague());
        currentMatchDay.setText(competitionList.get(position).getCurrentMatchDay());
        numberOfMatches.setText(competitionList.get(position).getNumberOfMatchdays());
        int imageResource = 0;
        switch(competitionList.get(position).getLeagueShortened()){
            case "PL":
                imageResource = R.mipmap.premier_league;
                break;
            case "BL1":
                imageResource = R.mipmap.bundesliga;
                break;
            case "SA":
                imageResource = R.mipmap.ic_launcher;
                break;
            case "PD":
                imageResource = R.mipmap.la_liga;
                break;
        }
        thumbnailImage.setBackgroundResource(imageResource);

        return rowView;

    }
}
