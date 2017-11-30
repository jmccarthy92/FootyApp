package com.example.android.footyapp.models;

/**
 * Created by globe_000 on 11/29/2017.
 */

public class Competition {

    private String id;
    private String league;
    private String currentMatchDay;
    private String numberOfMatchdays;
    private String numberOfTeams;
    private String numberOfGames;

    public Competition(String id, String league, String currentMatchDay,
                       String numberOfMatchdays, String numberOfTeams, String numberOfGames){
        this.id = id;
        this.league = league;
        this.currentMatchDay = currentMatchDay;
        this.numberOfMatchdays = numberOfMatchdays;
        this.numberOfTeams = numberOfTeams;
        this.numberOfGames = numberOfGames;
    }


    public String getNumberOfMatchdays() {
        return numberOfMatchdays;
    }

    public void setNumberOfMatchdays(String numberOfMatchdays) {
        this.numberOfMatchdays = numberOfMatchdays;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getCurrentMatchDay() {
        return currentMatchDay;
    }

    public void setCurrentMatchDay(String currentMatchDay) {
        this.currentMatchDay = currentMatchDay;
    }

    public String getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(String numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public String getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(String numberOfGames) {
        this.numberOfGames = numberOfGames;
    }



}
