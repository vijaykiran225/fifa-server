package com.vertx.eventbus.pingpong;

import io.vertx.core.AbstractVerticle;

public class Pong extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.eventBus().consumer("ping-pong",msg->{
            System.out.println("got msg : "+msg.body());
            msg.reply("pong");
        });
    }
}
