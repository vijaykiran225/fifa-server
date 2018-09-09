package com.vertx.eventbusdemo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Consumer extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        Router route=Router.router(vertx);
        route.get("/client1/:msg").handler(this::sendMsg);
        vertx.createHttpServer().requestHandler(route::accept).listen(8091);

        vertx.eventBus().consumer("chat").handler(x -> {
            System.out.println("msg from client 2 is " + x.body());
            x.reply("ack");
        });
    }

    private void sendMsg(RoutingContext routingContext) {

        String x = routingContext.pathParam("msg");
        routingContext.response().setStatusCode(200).end("done");

        vertx.eventBus().send("chat",x,resp->{
            System.out.println("sent msg to client 2"+x + "--"+resp.succeeded());
        });

    }
}
