package com.test.akka.actors;

import akka.actor.AbstractActor;

public class FirstActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, x -> System.out.println("got msg : "+x))
                .matchAny(m-> System.out.println("therla"))
                .build();
    }
}
