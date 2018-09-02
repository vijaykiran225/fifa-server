package com.test.springboot.controllers;

import com.test.springboot.model.mappers.EsResponseFifa17Mapper;
import com.test.springboot.services.ElasticService;
import com.test.springboot.model.ElasticResponse;
import com.test.springboot.model.Fifa17Player;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Component
@Path("/testApp")
public class FIFA17Controller {

    @Inject
    ElasticService elasticService;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Fifa17Player helloWorld(@PathParam("id") String id) throws ConfigurationException {
        Response resp = elasticService.readData(id);
        ElasticResponse elasticData = processResponse(resp, ElasticResponse.class);
        return EsResponseFifa17Mapper.map(elasticData,Fifa17Player.class).get();
    }

    private <T> T processResponse(Response response,Class<T> class1){
        
        if(response.getStatus()==200){
            return response.readEntity(class1);
        }
        else{
            Response errorResponse=Response.status(response.getStatus()).build();
            throw new WebApplicationException(errorResponse);
        }
    }
}
