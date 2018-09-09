package com.vertx.eventbusdemo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class Producer extends AbstractVerticle {

    @Override
    public void start() throws Exception {


        Router route=Router.router(vertx);
        route.get("/client2/:msg").handler(this::sendMsg);
        vertx.createHttpServer().requestHandler(route::accept).listen(8092);

        vertx.eventBus().consumer("chat").handler(x -> {
            System.out.println("msg from client 1 is " + x.body());
            x.reply("ack");
        });

    }
    private void sendMsg(RoutingContext routingContext) {

        String x = routingContext.pathParam("msg");
        routingContext.response().setStatusCode(200).end("done");

        vertx.eventBus().send("chat",x,resp->{
            System.out.println("sent msg to client 1 "+x + "--"+resp.succeeded());
        });
    }

}
