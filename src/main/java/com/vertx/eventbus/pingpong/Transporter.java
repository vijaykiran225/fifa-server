package com.vertx.eventbus.pingpong;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class Transporter extends AbstractVerticle {


    @Override
    public void start() throws Exception {
        vertx.deployVerticle(new Consumer());
        vertx.deployVerticle(new Producer());

        vertx.eventBus().consumer("stop").handler(x -> {
            vertx.undeploy("Transporter", resp->{
                System.out.println("about to undeply transpoter"+resp.succeeded());
            });
            vertx.close();
        });
    }

    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(new Transporter());
    }
}
