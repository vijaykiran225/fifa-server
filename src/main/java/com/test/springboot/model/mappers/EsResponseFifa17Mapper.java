package com.test.springboot.model.mappers;

import com.test.springboot.model.ElasticResponse;
import com.test.springboot.model.Fifa17Player;

import javax.ws.rs.core.Response;

public class EsResponseFifa17Mapper {


    public static Fifa17Player map(Response resp, Class<Fifa17Player> fifa17PlayerClass) {

        // resp.readEntity(ElasticResponse.class);


        return new Fifa17Player();
    }
}
