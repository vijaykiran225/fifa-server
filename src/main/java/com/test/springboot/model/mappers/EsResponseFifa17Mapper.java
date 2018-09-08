package com.test.springboot.model.mappers;

import com.test.springboot.model.response.elastic.ElasticResponse;
import com.test.springboot.model.response.Fifa17Player;
import com.test.springboot.model.response.elastic.Hit;
import com.test.springboot.model.response.elastic.Hits;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.test.springboot.util.CommonUtil.wrapOptional;

public class EsResponseFifa17Mapper {

    public static Function<Hit, Fifa17Player> fifa17PlayerMapper = aRecord -> {
        Fifa17Player player = new Fifa17Player();
        player.setName(aRecord.getSource().getName());
        player.setClub(aRecord.getSource().getClub());
        player.setNationality(aRecord.getSource().getNationality());
        player.setClubKit(Long.valueOf(aRecord.getSource().getClub_Kit()));
        player.setSpeed((aRecord.getSource().getSpeed()));
        return player;
    };

    public static List<Fifa17Player> mapCollection(ElasticResponse elasticData) {

        return wrapOptional(() -> elasticData.getHits())
                .map(Hits::getHits)
                .orElse(Collections.emptyList())
                .stream()
                .map(fifa17PlayerMapper)
                .collect(Collectors.toList());
    }


}
