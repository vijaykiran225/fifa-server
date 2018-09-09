package com.test.springboot.vertx.handler;

import com.test.springboot.model.response.Fifa17Player;
import com.test.springboot.services.ElasticService;
import com.test.springboot.util.LoggerUtil;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;
import org.elasticsearch.action.get.GetResponse;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Optional;

@Component
public class VertXRequestHandler {

    @Inject
    ElasticService elasticService;

    public static final Handler<AsyncResult<String>> deployStatusHandler = x -> {
        if (x.succeeded()) {
            LoggerUtil.logObject("deployed");
        } else {
            LoggerUtil.logObject("deploy failure", x.cause().getMessage());
        }
    };

    public final Handler<AsyncResult<HttpServer>> serverStatusHandler = x -> {
        if (x.succeeded()) {
            LoggerUtil.logObject("deployed");
        } else {
            LoggerUtil.logObject("deploy failure", x.cause().getMessage());
        }
    };

    public final Handler<RoutingContext> searchHandler = ctx->{
        ctx.response().setStatusCode(200);
        ctx.response().putHeader("Content-Type","application/json");

    };
    public final Handler<RoutingContext> failureHandler = ctx -> {
        ctx.response().setStatusCode(500).end("failed interally");
    };
    public  final Handler<RoutingContext> idHandler =  ctx->{
        ctx.response().setStatusCode(200);
        ctx.response().putHeader("Content-Type","application/json");

        Optional<GetResponse> resp = elasticService.readId(ctx.request().getParam("name"));

        if(resp.isPresent()){
            ctx.response().setStatusCode(200).end(Json.encode(resp.get()));
        }else{
            ctx.fail(500);
        }

//        Json.mapper.convertValue(ctx.getBodyAsString(),)
//        elasticService.readData(ctx.request().bodyHandler());
//        ctx.response().end(Json.encode(player));
    };;
}
