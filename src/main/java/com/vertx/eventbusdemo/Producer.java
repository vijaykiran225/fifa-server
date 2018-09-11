package com.vertx.eventbusdemo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class Producer extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        vertx.eventBus().consumer("chat1").handler(x -> {
            System.out.println("msg from Kakfaclient 1 is " + x.body());
            x.reply("ack");
            vertx.eventBus().send("chat",x.body(),resp->{
                System.out.println("sent msg to eventbus client 1 "+x + "--"+resp.succeeded());
            });
        });

    }

    public static void main(String[] args) {
        Vertx.clusteredVertx(new VertxOptions().setClustered(true),resp->{

            if (resp.succeeded()){
                Vertx vertx = resp.result();
                vertx.deployVerticle(new Producer());
            }
            else {
                resp.cause().printStackTrace();
            }
        });
    }

}
