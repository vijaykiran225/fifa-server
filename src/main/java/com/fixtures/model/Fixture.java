package com.fixtures.model;

public class Fixture {

    private String homeTeam;
    private String awayTeam;

    public Fixture(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return homeTeam + " vs "+ awayTeam ;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Fixture reverse(){
        return new Fixture(awayTeam,homeTeam);
    }
}
