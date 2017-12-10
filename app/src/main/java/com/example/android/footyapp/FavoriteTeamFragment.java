package com.example.android.footyapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.footyapp.async.HttpImageRequestTask;
import com.example.android.footyapp.data.AppDatabase;
import com.example.android.footyapp.data.DBWorker;
import com.example.android.footyapp.data.FavoriteTeam;
import com.example.android.footyapp.models.Team;
import com.example.android.footyapp.network.TeamUtils;

import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.List;


public class FavoriteTeamFragment extends Fragment {

    private OnFragmentInteractionListener mListener = dummyListener;
    private ImageView favoriteTeamCrest;
    private TextView favoriteTeamName, favoriteTeamGoals, favoriteTeamDraws, favoriteTeamLosses, favoriteTeamPoints;
    private RelativeLayout favoriteTeamLayout;

    public FavoriteTeamFragment() {
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
        return inflater.inflate(R.layout.fragment_favorite_team, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        favoriteTeamLayout = (RelativeLayout) view.findViewById(R.id.favorite_team_layout);
        favoriteTeamCrest = (ImageView) view.findViewById(R.id.favorite_team_crest);
        favoriteTeamName = (TextView) view.findViewById(R.id.favorite_team_name);
        favoriteTeamGoals = (TextView) view.findViewById(R.id.favorite_team_goals);
        favoriteTeamDraws = (TextView) view.findViewById(R.id.favorite_team_draws);
        favoriteTeamLosses = (TextView) view.findViewById(R.id.favorite_team_losses_value);
        favoriteTeamPoints = (TextView) view.findViewById(R.id.favorite_team_points_value);
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

    @Override public void onStart(){
        AsyncDBQuery asyncTask = new AsyncDBQuery(this.getActivity());
        asyncTask.execute();
        super.onStart();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private static FavoriteTeamFragment.OnFragmentInteractionListener dummyListener = new OnFragmentInteractionListener() {
    };

    public interface OnFragmentInteractionListener {

    }

    private class AsyncDBQuery extends AsyncTask<Void, Void, List<FavoriteTeam>>{

        private final WeakReference<Activity> weakActivity;

        public AsyncDBQuery(Activity activity){
            this.weakActivity = new WeakReference<>(activity);
        }

        @Override
        protected List<FavoriteTeam> doInBackground(final Void... params){
            Activity activity = weakActivity.get();
            if (activity == null
                    || activity.isFinishing()
                    ) {
                // activity is no longer valid, don't do anything!
                return null;
            }
            return DBWorker.getAll(AppDatabase.getAppDatabase(activity));
        }

        @Override
        protected  void onPostExecute(List<FavoriteTeam> fTeamList){
            FavoriteTeam fTeam = fTeamList.get(0);
            new AsyncFavoriteTeamRequest().execute(fTeam.getTeamCode(), fTeam.getTeamName());
        }

    }

    private class AsyncFavoriteTeamRequest extends AsyncTask<String, Void, Team>{

        // params 0 : Team URL Code
        // params 1 : Team Name
        @Override
        protected Team doInBackground(final String... params){
            TeamUtils tUtils = new TeamUtils();
            URL teamURL = tUtils.buildUrl(params[0]);
            Team team;
            try {
                String response = tUtils.getResponseFromHttpUrl(teamURL);
                team = tUtils.getResponseFromJson(response, params[1]);
                Log.d("JAMES",response);
                return team;
            } catch(Exception e){
                Log.e("JAMES", e.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(final Team team){
            HttpImageRequestTask hirTask = new HttpImageRequestTask(favoriteTeamCrest);
            hirTask.execute(team.getCrestURI());
            favoriteTeamName.setText(team.getTeamName());
            favoriteTeamGoals.setText(team.getGoals());
            favoriteTeamDraws.setText(team.getDraws());
            favoriteTeamLosses.setText(team.getLosses());
            favoriteTeamPoints.setText(team.getPoints());
            favoriteTeamLayout.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(v.getContext(), TeamActivity.class);
                    intent.putExtra("TEAM_NAME", team.getTeamName());
                    intent.putExtra("URL_CODE", team.getTeamId());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
