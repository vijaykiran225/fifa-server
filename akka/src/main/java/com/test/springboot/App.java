package com.test.springboot;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.test.akka.actors.FirstActor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        ActorSystem actorSystem=ActorSystem.create("test1");
        ActorRef actorRef = actorSystem.actorOf(Props.create(FirstActor.class));

        actorRef.tell("whatz aup ",ActorRef.noSender());

        BufferedReader a=new BufferedReader(new InputStreamReader(System.in));
        String content="";
        while ( (content=a.readLine()) !=null){
            actorRef.tell(content,ActorRef.noSender());
        }
        System.out.println( "Hello World!" );
    }
}
