package com.test.springboot.controllers;

import com.test.springboot.model.mappers.EsResponseFifa17Mapper;
import com.test.springboot.model.request.SearchRequest;
import com.test.springboot.model.request.SearchRequestV2;
import com.test.springboot.model.response.Fifa17Player;
import com.test.springboot.model.response.elastic.ElasticResponse;
import com.test.springboot.services.ElasticService;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.transport.TransportResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

import static com.test.springboot.util.CommonUtil.processResponse;

@RestController
@RequestMapping("/v2/FIFA")
public class FIFA17ControllerBoot {

    @Inject
    ElasticService elasticService;

    @GetMapping(value = "/players",produces= "application/json")
    public List<Fifa17Player> searchBoot(SearchRequestV2 search) {
        Response resp = elasticService.readData(search.getName());
        ElasticResponse elasticData = processResponse(resp, ElasticResponse.class);
        return EsResponseFifa17Mapper.mapCollection(elasticData);
    }


    @GetMapping(value="/players/{id}",produces = "application/json")
    public Response getPlayerBoot(@PathVariable("id") String id) {
        Optional<GetResponse> resp = elasticService.readId(id);
//        ElasticResponse elasticData = processResponse(resp, ElasticResponse.class);
//        return EsResponseFifa17Mapper.mapCollection(elasticData);
        if (resp.isPresent())
        return Response.status(202).entity(resp.get()).build();
        else return Response.status(500).build();
    }


}
