package com.vertx.eventbus.pingpong;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class Main extends AbstractVerticle {


    @Override
    public void start() throws Exception {
        vertx.deployVerticle(new Ping());
        vertx.deployVerticle(new Pong());

    }

    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(new Main());
    }
}
