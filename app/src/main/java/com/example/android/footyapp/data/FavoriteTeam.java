package com.example.android.footyapp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by globe_000 on 11/29/2017.
 */
@Entity(tableName = "favorite_team")
public class FavoriteTeam {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "team_code")
    private String teamCode;

    @ColumnInfo(name = "team_name")
    private String teamName;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
