package com.example.android.footyapp.async;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.android.footyapp.data.AppDatabase;
import com.example.android.footyapp.data.DBWorker;
import com.example.android.footyapp.data.FavoriteTeam;
import com.example.android.footyapp.models.Team;

import java.lang.ref.WeakReference;

/**
 * Created by globe_000 on 12/10/2017.
 */

public class AsyncDbWorker extends AsyncTask<Team, Void, FavoriteTeam> {

    private final WeakReference<Activity> weakActivity;

    public AsyncDbWorker(Activity activity){
        this.weakActivity = new WeakReference<>(activity);
    }

    @Override
    protected FavoriteTeam doInBackground(Team... params){
        Activity activity = weakActivity.get();
        if (activity == null
                || activity.isFinishing()
                ) {
            // activity is no longer valid, don't do anything!
            return null;
        }
        FavoriteTeam fTeam = new FavoriteTeam();
        fTeam.setTeamCode(params[0].getTeamId());
        fTeam.setTeamName(params[0].getTeamName());
        return DBWorker.insertTeam(AppDatabase.getAppDatabase(activity), fTeam);
    }

    @Override
    protected void onPostExecute(FavoriteTeam team){
        Activity activity = weakActivity.get();
        if (activity == null
                || activity.isFinishing()
                ) {
            // activity is no longer valid, don't do anything!
            return;
        }
        if( team != null){
            Toast.makeText(activity, "'"+team.getTeamName()+"' has been added to favourites", Toast.LENGTH_LONG).show();
        }
    }
}
