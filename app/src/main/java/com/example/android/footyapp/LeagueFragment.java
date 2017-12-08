package com.example.android.footyapp;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.footyapp.models.League;
import com.example.android.footyapp.network.LeagueUtils;

import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;


public class LeagueFragment extends Fragment {




    private OnFragmentInteractionListener mListener = dummyListener;

    public LeagueFragment() {
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
        return inflater.inflate(R.layout.fragment_league, container, false);
    }

    @Override
    public void onStart(){
        AsyncLeagueRequest task = new AsyncLeagueRequest(this.getActivity());
        task.execute();
        super.onStart();
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
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private static LeagueFragment.OnFragmentInteractionListener dummyListener = new OnFragmentInteractionListener() {
    };

    public interface OnFragmentInteractionListener {

    }

    public String getUrlCode(){
        Bundle extras = getActivity().getIntent().getExtras();
        if( extras == null){
            return null;
        } else {
            return extras.getString("URL_CODE");
        }
    }


    private class AsyncLeagueRequest extends AsyncTask<String, Void, ArrayList<League>>{

        private final WeakReference<Activity> weakActivity;

        public AsyncLeagueRequest(Activity myActivity){
            this.weakActivity = new WeakReference<>(myActivity);
        }

        @Override
        protected ArrayList<League> doInBackground(final String... params){
            LeagueUtils lUtils = new LeagueUtils();
            URL leagueURL = lUtils.buildUrl(getUrlCode());
            ArrayList<League> leagueList;

            try {
                String response = lUtils.getResponseFromHttpUrl(leagueURL);
                leagueList = lUtils.getResponseFromJson(response);
                Log.d("JAMES", response);
                return leagueList;
            } catch(Exception e){
                Log.d("JAMES", e.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<League> leagueList){
            View fragmentView = getView();
            Activity activity = weakActivity.get();
            if (activity == null
                    || activity.isFinishing()
                    ) {
                // activity is no longer valid, don't do anything!
                return;
            }

            LeagueAdapter  leagueAdapter = new LeagueAdapter(leagueList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity,
                                                        LinearLayoutManager.VERTICAL, false);

            RecyclerView recyclerView = (RecyclerView) fragmentView.findViewById(R.id.recycler_view_league);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(leagueAdapter);
        }




    }
}
