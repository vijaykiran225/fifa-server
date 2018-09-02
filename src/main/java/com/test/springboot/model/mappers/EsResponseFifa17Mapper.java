package com.test.springboot.model.mappers;

import com.test.springboot.model.ElasticResponse;
import com.test.springboot.model.Fifa17Player;

import java.util.stream.Stream;
import java.util.Optional;

public class EsResponseFifa17Mapper {


    public static Optional<Fifa17Player> map(ElasticResponse elasticData, Class<Fifa17Player> fifa17PlayerClass) {

        return Stream.of(elasticData.getHits().getHits())
                .map(aRecord -> {
                    Fifa17Player player= new Fifa17Player();
                    player.setName(aRecord.getSource().getName());
                    player.setClub(aRecord.getSource().getClub());
                    player.setNationality(aRecord.getSource().getNationality());
                    player.setClubKit(aRecord.getSource().getClubKit());
                    player.setNationalKit(aRecord.getSource().getNationalKit());
                    return player;  
                })
                .findFirst();
    }
}
