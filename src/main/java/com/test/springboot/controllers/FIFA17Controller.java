package com.test.springboot.controllers;

import com.test.springboot.model.mappers.EsResponseFifa17Mapper;
import com.test.springboot.services.ElasticService;
import com.test.springboot.model.Fifa17Player;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Component
@Path("/testApp")
public class FIFA17Controller {

    @Value("${es.baseUrl}")
    String baseUrl;

    @Inject
    ElasticService elasticService;

    @GET
    @Path("/{id}")
    @Produces("text/plain")
    public Fifa17Player helloWorld(@PathParam("id") String id) throws ConfigurationException {
        Response resp = elasticService.readData(id);

        return EsResponseFifa17Mapper.map(resp,Fifa17Player.class);
    }
}
