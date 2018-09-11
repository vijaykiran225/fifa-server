package com.springboot.controllers;

import com.springboot.vertx.handler.VertXRequestHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.TimeoutHandler;
import org.springframework.stereotype.Component;

import javax.inject.Inject;


@Component
public class FIFA17ControllerVertX  {

    @Inject
    VertXRequestHandler handler;

//    @Override
    public void start() throws Exception {

        Vertx vertx = Vertx.vertx();
        Router x = Router.router(vertx);
        x.get("/v3/FIFA/players").handler(handler.searchHandler).failureHandler(handler.failureHandler).produces("application/json");
        x.get("/v3/FIFA/players/:name")
                .handler(TimeoutHandler.create(10000))
                .handler(handler.idHandler)
                .failureHandler(handler.failureHandler)
                .produces("application/json");
        vertx.createHttpServer().requestHandler(x::accept).listen(8091, handler.serverStatusHandler);
    }
}
