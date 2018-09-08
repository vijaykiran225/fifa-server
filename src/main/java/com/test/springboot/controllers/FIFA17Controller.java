package com.test.springboot.controllers;

import com.test.springboot.model.mappers.EsResponseFifa17Mapper;
import com.test.springboot.model.request.SearchRequest;
import com.test.springboot.services.ElasticService;
import com.test.springboot.model.response.elastic.ElasticResponse;
import com.test.springboot.model.response.Fifa17Player;
import org.springframework.stereotype.Component;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static com.test.springboot.util.CommonUtil.processResponse;

@Component
@Path("/v1/FIFA")
public class FIFA17Controller {

    @Inject
    ElasticService elasticService;

    @GET
    @Path("players")
    @Produces("application/json")
    public List<Fifa17Player> search(@BeanParam SearchRequest search) {
        Response resp = elasticService.readData(search.getName());
        ElasticResponse elasticData = processResponse(resp, ElasticResponse.class);
        return EsResponseFifa17Mapper.mapCollection(elasticData);
    }


    @GET
    @Path("players/{id}")
    @Produces("application/json")
    public List<Fifa17Player> getPlayer(@PathParam("id") String id) {
        Response resp = elasticService.readData(id);
        ElasticResponse elasticData = processResponse(resp, ElasticResponse.class);
        return EsResponseFifa17Mapper.mapCollection(elasticData);
    }


}
