package com.example.android.footyapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.footyapp.models.Competition;
import com.example.android.footyapp.network.Competitionutils;

import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

//Competition Fragment class for modularity, and reusability
public class CompetitionFragment extends Fragment {

    private OnFragmentInteractionListener mListener = dummyListener;
    private FrameLayout frameLayout;
//    private fiint compOrientation = Activity.getResources().getConfiguration().orientation;

    public CompetitionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("JAMMY", "oh my lord");
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        frameLayout = new FrameLayout(getActivity());
        inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_competition, null);
        frameLayout.addView(view);
        return frameLayout;
        //return inflater.inflate(R.layout.fragment_competition, container, false);
    }

    @Override
    public void onStart(){
        AsyncCompetitionRequest task = new AsyncCompetitionRequest(this.getActivity());
        task.execute();
        super.onStart();

    }

    public void onConfigurationChanged(Configuration config){
        super.onConfigurationChanged(config);
        //         Had to use this strategy because of the Adapter class being used on a fragment class.
        frameLayout.removeAllViews();
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View newView = inflater.inflate(R.layout.fragment_competition, null);
        frameLayout.addView(newView);
        AsyncCompetitionRequest task = new AsyncCompetitionRequest(this.getActivity());
        task.execute();
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

    private static OnFragmentInteractionListener dummyListener = new OnFragmentInteractionListener(){

    };

    public interface OnFragmentInteractionListener {

    }

    //    Async task to Make API Request and fill Views with live footy data
    private class AsyncCompetitionRequest extends AsyncTask<Void, Void, HashMap<String,Competition>> {

        private final WeakReference<Activity> weakActivity;

        AsyncCompetitionRequest(Activity myActivity){
            this.weakActivity = new WeakReference<>(myActivity);
        }
        @Override
        protected HashMap<String,Competition> doInBackground(final Void... params){
            Competitionutils cUtils = new Competitionutils();
            URL competitionDataURL = cUtils.buildUrl("");
            HashMap<String, Competition> competitionMap;


            try {
                String response = cUtils.getResponseFromHttpUrl(competitionDataURL);
                competitionMap = cUtils.getResponseFromJson(response);
                Log.d("JAMES", competitionMap.toString());
                return competitionMap;
            } catch(Exception e){
                Log.d("JAMES" , e.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(HashMap<String,Competition> competitionList){
            View fragmentView = getView();
            Activity activity = weakActivity.get();
            if (activity == null
                    || activity.isFinishing()
                    ) {
                // activity is no longer valid, don't do anything!
                return;
            }

            ArrayList<Competition> competitionArrList = new ArrayList<Competition>(competitionList.values());
            CompetitionAdapter competitionAdapter = new CompetitionAdapter(activity, competitionArrList, getActivity().getResources().getConfiguration().orientation );
            ListView listView = (ListView) fragmentView.findViewById(R.id.competitionDisplay);
            listView.setAdapter(competitionAdapter);
        }
    }
}
