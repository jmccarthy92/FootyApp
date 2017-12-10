package com.example.android.footyapp.models;

/**
 * Created by globe_000 on 11/29/2017.
 */

public class Team {

    private String teamName;

    private String teamId;
    private String crestURI;
    private String playedGames;
    private String points;
    private String wins;
    private String draws;
    private String losses;
    private String goals;
    private String goalsAgainst;
    private String goalDifference;
    private String position;
    private String homeGoals;
    private String homeGoalsAgainst;
    private String homeWins;
    private String homeDraws;
    private String homeLosses;
    private String awayGoals;
    private String awayGoalsAgainst;
    private String awayWins;
    private String awayDraws;
    private String awayLosses;

    public Team(String teamName, String crestURI, String playedGames, String points, String wins, String draws,
                String losses, String goals, String goalsAgainst, String goalDifference, String position,
                String homeGoals, String homeGoalsAgainst, String homeWins, String homeDraws, String homeLosses,
                String awayGoals, String awayGoalsAgainst, String awayWins, String awayDraws, String awayLosses) {
        this.teamName = teamName;
        this.crestURI = crestURI;
        this.playedGames = playedGames;
        this.points = points;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.goals = goals;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
        this.position = position;
        this.homeGoals = homeGoals;
        this.homeGoalsAgainst = homeGoalsAgainst;
        this.homeWins = homeWins;
        this.homeDraws = homeDraws;
        this.homeLosses = homeLosses;
        this.awayGoals = awayGoals;
        this.awayGoalsAgainst = awayGoalsAgainst;
        this.awayWins = awayWins;
        this.awayDraws = awayDraws;
        this.awayLosses = awayLosses;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCrestURI() {
        return crestURI;
    }

    public void setCrestURI(String crestURI) {
        this.crestURI = crestURI;
    }

    public String getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(String playedGames) {
        this.playedGames = playedGames;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getDraws() {
        return draws;
    }

    public void setDraws(String draws) {
        this.draws = draws;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(String goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public String getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(String goalDifference) {
        this.goalDifference = goalDifference;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(String homeGoals) {
        this.homeGoals = homeGoals;
    }

    public String getHomeGoalsAgainst() {
        return homeGoalsAgainst;
    }

    public void setHomeGoalsAgainst(String homeGoalsAgainst) {
        this.homeGoalsAgainst = homeGoalsAgainst;
    }

    public String getHomeWins() {
        return homeWins;
    }

    public void setHomeWins(String homeWins) {
        this.homeWins = homeWins;
    }

    public String getHomeDraws() {
        return homeDraws;
    }

    public void setHomeDraws(String homeDraws) {
        this.homeDraws = homeDraws;
    }

    public String getHomeLosses() {
        return homeLosses;
    }

    public void setHomeLosses(String homeLosses) {
        this.homeLosses = homeLosses;
    }

    public String getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(String awayGoals) {
        this.awayGoals = awayGoals;
    }

    public String getAwayGoalsAgainst() {
        return awayGoalsAgainst;
    }

    public void setAwayGoalsAgainst(String awayGoalsAgainst) {
        this.awayGoalsAgainst = awayGoalsAgainst;
    }

    public String getAwayWins() {
        return awayWins;
    }

    public void setAwayWins(String awayWins) {
        this.awayWins = awayWins;
    }

    public String getAwayDraws() {
        return awayDraws;
    }

    public void setAwayDraws(String awayDraws) {
        this.awayDraws = awayDraws;
    }

    public String getAwayLosses() {
        return awayLosses;
    }

    public void setAwayLosses(String awayLosses) {
        this.awayLosses = awayLosses;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
