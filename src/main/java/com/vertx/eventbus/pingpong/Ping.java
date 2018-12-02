package com.vertx.eventbus.pingpong;

import io.vertx.core.AbstractVerticle;

public class Ping extends AbstractVerticle {

    @Override
    public void start() throws Exception {


        vertx.setPeriodic(1000, i->
        vertx.eventBus().send("ping-pong" , "ping"+i,reply -> {
            if (reply.succeeded()){
                System.out.println("got reply : "+reply.result().body());
            }else {
                System.err.println("no reply");
            }
        }));
    }
}
