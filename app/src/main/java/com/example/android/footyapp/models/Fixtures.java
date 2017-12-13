package com.example.android.footyapp.models;


/**
 * Created by globe_000 on 11/29/2017.
 */
//Object Wrapper class for Fixture data.
public class Fixtures {

    private String date;
    private String status;
    private String matchday;
    private String homeTeamName;
    private String awayTeamName;
    private String goalsHomeTeam;
    private String goalsAwayTeam;

    public Fixtures(String date, String status, String matchday, String homeTeamName,
                        String awayTeamName, String goalsHomeTeam, String goalsAwayTeam) {
        this.date = date;
        this.status = status;
        this.matchday = matchday;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public String getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(String goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public String getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(String goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMatchday() {
        return matchday;
    }

    public void setMatchday(String matchday) {
        this.matchday = matchday;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }



}
