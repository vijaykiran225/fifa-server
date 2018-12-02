package com.fixtures.generator;

import com.fixtures.model.Fixture;
import com.fixtures.model.MatchDay;
import com.fixtures.model.Season;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator {

    private static List<String> teams = IntStream.range(0,20).mapToObj(String::valueOf).collect(Collectors.toList());

    public static void main(String[] args) {
        List<String> left = new ArrayList<>(teams.subList(0, teams.size() / 2));

        List<String> right = new ArrayList<>(teams.subList(teams.size() / 2, teams.size()));

        generate(left, right);

    }

    public static void generate(List<String> left, List<String> right) {

        Season season = new Season();
        for (int i = 0; i < teams.size() - 1; i++) {


            season.addMatchDay(
                    new MatchDay(
                            IntStream
                                .range(0, left.size())
                                .mapToObj(j -> new Fixture(left.get(j), right.get(j)))
                                .peek(System.out::println)
                                .collect(Collectors.toList())
                    )
            );
            rotate(left, right);

        }
    }

    public static void fixDoubleRotation(List<String> right) {
        String rightEnd = right.remove(right.size()-1);
        right.add(right.size()-1,rightEnd);
    }

    public static void rotate(List<String> left, List<String> right) {
        String rightHead = right.remove(0);
        String leftEnd = left.remove(left.size()-1);

        left.add(0,rightHead);
        right.add(leftEnd);
        fixDoubleRotation(right);
    }
}
