package com.test.springboot.controllers;

import com.test.springboot.model.mappers.EsResponseFifa17Mapper;
import com.test.springboot.model.request.SearchRequest;
import com.test.springboot.model.request.SearchRequestV2;
import com.test.springboot.model.response.Fifa17Player;
import com.test.springboot.model.response.elastic.ElasticResponse;
import com.test.springboot.services.ElasticService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static com.test.springboot.util.CommonUtil.processResponse;

@Component
@RequestMapping("v2/FIFA")
public class FIFA17ControllerBoot {

    @Inject
    ElasticService elasticService;

    @GetMapping(path = "players",produces= "application/json")
    public List<Fifa17Player> search(SearchRequestV2 search) {
        Response resp = elasticService.readData(search.getName());
        ElasticResponse elasticData = processResponse(resp, ElasticResponse.class);
        return EsResponseFifa17Mapper.mapCollection(elasticData);
    }


    @GetMapping(path="players/{id}",produces = "application/json")
    public List<Fifa17Player> getPlayer(@PathVariable("id") String id) {
        Response resp = elasticService.readData(id);
        ElasticResponse elasticData = processResponse(resp, ElasticResponse.class);
        return EsResponseFifa17Mapper.mapCollection(elasticData);
    }


}
