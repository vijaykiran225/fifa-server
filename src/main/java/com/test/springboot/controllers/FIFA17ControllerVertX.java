package com.test.springboot.controllers;

import com.test.springboot.vertx.handler.VertXRequestHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.TimeoutHandler;
import org.springframework.stereotype.Component;

import javax.inject.Inject;


@Component
public class FIFA17ControllerVertX extends AbstractVerticle {

    @Inject
    VertXRequestHandler handler;

    @Override
    public void start() throws Exception {

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
