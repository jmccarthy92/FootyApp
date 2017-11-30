package com.example.android.footyapp.data;

import java.util.List;

/**
 * Created by globe_000 on 11/29/2017.
 */

public class DBWorker {

    public static FavoriteTeam insertTeam(final AppDatabase db, FavoriteTeam favoriteTeam){
        db.favoriteTeamDao().insertAll(favoriteTeam);
        return favoriteTeam;
    }

    public static boolean deleteTeam(final AppDatabase db, FavoriteTeam favoriteTeam){
        int count = db.favoriteTeamDao().delete(favoriteTeam);
        if(count < 1)
            return false;
        return true;
    }

    public static List<FavoriteTeam> getAll(AppDatabase db){
        return db.favoriteTeamDao().getAll();
    }
}
