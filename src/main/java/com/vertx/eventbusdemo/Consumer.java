package com.vertx.eventbusdemo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Consumer extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        vertx.eventBus().consumer("chat").handler(x -> {
            System.out.println("received msg from event bus client 2 is " + x.body());
            x.reply("ack");
        });
    }

    public static void main(String[] args) {
        VertxOptions options = new VertxOptions().setClustered(true);
        Vertx.clusteredVertx(options, resp->{

            if (resp.succeeded()){
                Vertx vertx = resp.result();
                vertx.deployVerticle(new Consumer());
            }
            else {
                resp.cause().printStackTrace();
            }
        });
    }
}
