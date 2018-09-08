package com.test.springboot.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils; 
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
public class ElasticService {

    @Value("${es.baseUrl}")
    String baseUrl;

    String query="{\n" +
            "   \"_source\": {\n" +
            "        \"includes\": [ \"Name\" ]\n" +
            "    },\n" +
            "  \"query\": {\n" +
            "    \"range\": {\n" +
            "      \"Freekick_Accuracy\": {\n" +
            "        \"gte\": 80,\n" +
            "        \"lte\": 90\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";

    String nameSearch="{\n" +
//            " \"from\" : <<REPLACE_FROM>>, \"size\" : <<REPLACE_SIZE>>,"+
            "  \"query\": {\n" +
            "    \"match\": {\n" +
            "      \"Name\": \"<<REPLACE>>\"\n" +
            "    }\n" +
            "  }\n" +
            "}";

    public Response readData(String name){
        WebTarget target= ClientBuilder.newBuilder().build()
                .target(baseUrl)
                .path("_search")
                .queryParam("filter_path", "took,hits.total,hits.hits._id,hits.hits._source*");

        String x= StringUtils.isNotEmpty(name) ?nameSearch.replace("<<REPLACE>>",name) : "";
        
        Response response = target
            .request(MediaType.APPLICATION_JSON_TYPE)
            .post(Entity.json(x));
        return response;
    }
}
