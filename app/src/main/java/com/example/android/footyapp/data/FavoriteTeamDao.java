package com.example.android.footyapp.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by globe_000 on 11/29/2017.
 */

@Dao
public interface FavoriteTeamDao {

    @Query("SELECT * FROM favorite_team ORDER BY 1 DESC LIMIT 1")
    List<FavoriteTeam> getAll();

    @Insert
    void insertAll(FavoriteTeam... favoriteTeams);

    @Delete
    int delete(FavoriteTeam favoriteTeam);


}
