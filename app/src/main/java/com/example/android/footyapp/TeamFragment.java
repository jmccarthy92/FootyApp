package com.example.android.footyapp;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.footyapp.async.AsyncDbWorker;
import com.example.android.footyapp.async.HttpImageRequestTask;
import com.example.android.footyapp.models.Team;
import com.example.android.footyapp.network.TeamUtils;

import java.lang.ref.WeakReference;
import java.net.URL;


public class TeamFragment extends Fragment {

    private OnFragmentInteractionListener mListener = dummyListener;
    private ImageView teamCrest;
    private Button favouriteButton;
    private TextView name, wins, draws, losses, playedGames, points, goals, goalsAgainst,
                    goalDifference, homeGoals, homeGoalsAgainst, homeWins, homeDraws,
                    homeLosses, awayGoals, awayGoalsAgainst, awayWins, awayDraws, awayLosses;
    private final String urlCode = "URL_CODE";
    private final String teamNameKey = "TEAM_NAME";


    public TeamFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        teamCrest = (ImageView) view.findViewById(R.id.team_crest);
        favouriteButton = (Button) view.findViewById(R.id.favorite_button);
        name = (TextView) view.findViewById(R.id.team_name);
        wins = (TextView) view.findViewById(R.id.wins);
        draws = (TextView) view.findViewById(R.id.draws);
        losses = (TextView) view.findViewById(R.id.losses);
        playedGames = (TextView) view.findViewById(R.id.played_games);
        points = (TextView) view.findViewById(R.id.points);
        goals = (TextView) view.findViewById(R.id.goals);
        goalsAgainst = (TextView) view.findViewById(R.id.goals_against);
        goalDifference = (TextView) view.findViewById(R.id.goal_difference);
        homeGoals = (TextView) view.findViewById(R.id.home_goals);
        homeGoalsAgainst = (TextView) view.findViewById(R.id.home_goals_against);
        homeWins = (TextView) view.findViewById(R.id.home_wins);
        homeDraws = (TextView) view.findViewById(R.id.home_draws);
        homeLosses = (TextView) view.findViewById(R.id.home_losses);
        awayGoals = (TextView) view.findViewById(R.id.away_goals);
        awayGoalsAgainst = (TextView) view.findViewById(R.id.away_goals_against);
        awayWins = (TextView) view.findViewById(R.id.away_wins);
        awayDraws = (TextView) view.findViewById(R.id.away_draws);
        awayLosses = (TextView) view.findViewById(R.id.away_losses);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onStart(){
        AsyncTeamRequest asyncTask = new AsyncTeamRequest(this.getActivity());
        asyncTask.execute();
        super.onStart();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public String getBundleExtras(String key){
        Bundle extras = getActivity().getIntent().getExtras();
        if( extras == null){
            return null;
        } else {
            return extras.getString(key);
        }
    }



    private static TeamFragment.OnFragmentInteractionListener dummyListener = new OnFragmentInteractionListener() {
    };

    public interface OnFragmentInteractionListener {

    }

    private class AsyncTeamRequest extends AsyncTask<String, Void, Team>{

        private final WeakReference<Activity> weakActivity;

        AsyncTeamRequest(Activity myActivity){
            this.weakActivity = new WeakReference<>(myActivity);
        }

        @Override protected Team doInBackground(final String... params){
            TeamUtils tUtils = new TeamUtils();
            URL teamURL = tUtils.buildUrl(getBundleExtras(urlCode));
            Team team;
            try {
                String response = tUtils.getResponseFromHttpUrl(teamURL);
                team = tUtils.getResponseFromJson(response, getBundleExtras(teamNameKey));
                Log.d("JAMES",response);
                return team;
            } catch(Exception e){
                Log.e("JAMES", e.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(final Team team){
            HttpImageRequestTask hirTask = new HttpImageRequestTask(teamCrest);
            hirTask.execute(team.getCrestURI());
            name.setText(team.getTeamName());
            wins.setText(team.getWins());
            draws.setText(team.getDraws());
            losses.setText(team.getLosses());
            playedGames.setText(team.getPlayedGames());
            points.setText(team.getPoints());
            goals.setText(team.getGoals());
            goalsAgainst.setText(team.getGoalsAgainst());
            goalDifference.setText(team.getGoalDifference());
            homeGoals.setText(team.getHomeGoals());
            homeGoalsAgainst.setText(team.getHomeGoalsAgainst());
            homeWins.setText(team.getHomeWins());
            homeDraws.setText(team.getHomeDraws());
            homeLosses.setText(team.getHomeLosses());
            awayGoals.setText(team.getAwayGoals());
            awayGoalsAgainst.setText(team.getAwayGoalsAgainst());
            awayWins.setText(team.getAwayWins());
            awayDraws.setText(team.getAwayDraws());
            awayLosses.setText(team.getAwayLosses());
            final Activity activity = weakActivity.get();
            if (activity == null
                    || activity.isFinishing()
                    ) {
                // activity is no longer valid, don't do anything!
                return;
            }
            favouriteButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    AsyncDbWorker adw = new AsyncDbWorker(activity);
                    adw.execute(team);
                }
            });

        }
    }
}
