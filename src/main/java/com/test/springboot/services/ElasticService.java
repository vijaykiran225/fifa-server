package com.test.springboot.services;

import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils; 
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@Component
public class ElasticService {

    private final String includedFields = "took,hits.total,hits.hits._id,hits.hits._source*";
    @Value("${es.baseUrl}")
    String baseUrl;

    @Autowired
    Environment env;

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
                .queryParam("filter_path", includedFields);

        String x= StringUtils.isNotEmpty(name) ?nameSearch.replace("<<REPLACE>>",name) : "";
        
        Response response = target
            .request(MediaType.APPLICATION_JSON_TYPE)
            .post(Entity.json(x));
        return response;
    }

    public Optional<GetResponse> readId(String playerId)  {

        try{
            int port = Integer.parseInt(env.getProperty("es.port"));
            String host =env.getProperty("es.host");;
            String type=env.getProperty("es.type");
            String index=env.getProperty("es.index");

            TransportClient transportClient= new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
            GetResponse x = transportClient.prepareGet(index, type, playerId).setFetchSource(includedFields,null).get();

            return Optional.ofNullable(x);
        }
        catch (Exception e){
            return Optional.empty();
        }
    }
}
