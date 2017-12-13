package com.example.android.footyapp.models;

/**
 * Created by globe_000 on 11/29/2017.
 */
//Object Wrapper class for Player data.
public class Player {

    private String name;
    private String position;
    private String jerseyNumber;
    private String dateOfBirth;
    private String nationality;
    private String contractUntil;

    public Player(String name, String position, String jerseyNumber,
                  String dateOfBirth, String nationality, String contractUntil){
        this.name = name;
        this.position = position;
        this.nationality = nationality;
        this.contractUntil = contractUntil;
        this.dateOfBirth = dateOfBirth;
        this.jerseyNumber = jerseyNumber;
    }

    //position
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    //Jersey
    public String getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(String jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }
    //DateOfBirth
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    //nationality
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    //contractUntil
    public String getContractUntil() {
        return contractUntil;
    }

    public void setContractUntil(String contractUntil) {
        this.contractUntil = contractUntil;
    }
    //Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
