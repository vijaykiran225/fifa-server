package com.fixtures.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Season {
    private List<MatchDay> springMatchDays;
    private List<MatchDay> winterMatchDays;


    public Season() {
        this.springMatchDays=new ArrayList<>();
        this.winterMatchDays=new ArrayList<>();
    }

    public List<MatchDay> getWinterMatchDays() {
        return winterMatchDays;
    }

    public void setWinterMatchDays(List<MatchDay> winterMatchDays) {
        this.winterMatchDays = winterMatchDays;
    }

    public List<MatchDay> getSpringMatchDays() {
        return springMatchDays;
    }

    public void setSpringMatchDays(List<MatchDay> springMatchDays) {
        this.springMatchDays = springMatchDays;
    }

    @Override
    public String toString() {
        String x = springMatchDays.stream().map(MatchDay::toString).collect(Collectors.joining("\n"));
        String y = winterMatchDays.stream().map(MatchDay::toString).collect(Collectors.joining("\n"));

        return x+"\n"+y;
    }

    public void addMatchDay(MatchDay day) {
        this.springMatchDays.add(day);
    }
    public void addMatchDays(List<MatchDay> day) {
        this.springMatchDays.addAll(day);
    }
}
