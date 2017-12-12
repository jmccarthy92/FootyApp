package com.example.android.footyapp;

/**
 * Created by globe_000 on 12/6/2017.
 */


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.footyapp.async.HttpImageRequestTask;
import com.example.android.footyapp.helper.ImageResourceWorker;
import com.example.android.footyapp.models.League;
import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder> {

    private ArrayList<League> leagueData;


    public LeagueAdapter(ArrayList<League> leagueData){
        this.leagueData = leagueData;
        //Log.d("JAMES", leagueData.toString());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class LeagueViewHolder extends RecyclerView.ViewHolder {
        public ImageView teamCrest;
        public TextView teamName, teamPlayedGames, teamWins, teamDraws,
                        teamLosses,teamGoals,teamGoalDifference, teamTablePoints, teamRank;
        public RelativeLayout leagueRow;

        public LeagueViewHolder(View v){
            super(v);
            Log.d("JAMES","MADE IT HERE");
            leagueRow = (RelativeLayout) v.findViewById(R.id.league_row);
            teamRank = (TextView) v.findViewById(R.id.team_rank);
            teamCrest = (ImageView) v.findViewById(R.id.team_table_image);
            teamName = (TextView) v.findViewById(R.id.team_table_name);
            teamPlayedGames = (TextView) v.findViewById(R.id.team_table_played_games);
            teamWins = (TextView) v.findViewById(R.id.team_table_wins);
            teamDraws = (TextView) v.findViewById(R.id.team_table_draws);
            teamLosses = (TextView) v.findViewById(R.id.team_table_losses);
            teamGoals = (TextView) v.findViewById(R.id.team_table_goals);
            teamGoalDifference = (TextView) v.findViewById(R.id.team_table_goal_difference);
            teamTablePoints = (TextView) v.findViewById(R.id.team_table_points);
//            RelativeLayout relativeLayout = (RelativeLayout) v.findViewById(R.id.league_row);
//            relative
        }
    }

    @Override
    public LeagueViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.league_row, viewGroup, false);
        return new LeagueViewHolder(view);
    }

    @Override
    public int getItemCount(){
        if( null == leagueData) return 0;
        return leagueData.size();
    }

    public void setLeagueData(ArrayList<League> leagueData){
        this.leagueData = leagueData;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(LeagueViewHolder viewHolder, int position){
        final League league = leagueData.get(position);
        Log.d("JAMES", "MADE IT HERE FUCKER");
        if(ImageResourceWorker.isBrokenSVG_Crest(league.getCrestURI())){
            ImageResourceWorker.renderCrestImage(viewHolder.teamCrest, league.getCrestURI());
        } else {
            HttpImageRequestTask hirTask = new HttpImageRequestTask(viewHolder.teamCrest);
            hirTask.execute(league.getCrestURI());
        }

        viewHolder.teamRank.setText(String.valueOf(position + 1));
        viewHolder.teamName.setText(league.getTeamName());
        viewHolder.teamPlayedGames.setText(league.getPlayedGames());
        viewHolder.teamWins.setText(league.getWins());
        viewHolder.teamDraws.setText(league.getDraws());
        viewHolder.teamLosses.setText(league.getLosses());
        viewHolder.teamGoals.setText(league.getGoals());
        viewHolder.teamGoalDifference.setText(league.getGoalDifference());
        viewHolder.teamTablePoints.setText(league.getPoints());
        viewHolder.leagueRow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), TeamActivity.class);
                intent.putExtra("TEAM_NAME", league.getTeamName());
                intent.putExtra("URL_CODE", league.getId() );
                v.getContext().startActivity(intent);
            }
        });



    }


}
