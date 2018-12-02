package com.fixtures.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MatchDay {

    public static final Function<Fixture, String> AWAY_TEAM = Fixture::getAwayTeam;
    public static final Function<Fixture, String> HOME_TEAM = Fixture::getHomeTeam;
    private List<Fixture> fixtures;

    public MatchDay(List<Fixture> matchDay) {
        this.fixtures = matchDay;
    }

    public MatchDay() {
        this.fixtures=new ArrayList<>();
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

    public void addToMatchDay(List<Fixture> fixtures) {
        this.fixtures.addAll(fixtures);
    }

    public void addToMatchDay(Fixture fixture) {
        this.fixtures.add(fixture);
    }

    public boolean hasHomeTeam(String team){
        return fixtures.stream().map(HOME_TEAM).anyMatch(x-> x.equals(team));
    }

    public boolean hasAwayTeam(String team){
        return fixtures.stream().map(AWAY_TEAM).anyMatch(x-> x.equals(team));
    }

    public boolean hasTeam(String team,Function<Fixture,String> side){
        return fixtures.stream().map(side).anyMatch(x-> x.equals(team));
    }

    public long countOf(String team, Function<Fixture,String> side){
        return fixtures.stream().map(side).filter(x -> x.equals(team)).count();
    }

    @Override
    public String toString() {
        return fixtures.stream().map(Fixture::toString).collect(Collectors.joining("\n"));
    }

    public void shuffle() {
        Collections.shuffle(fixtures);
    }
}
