package com.test.akka.stream;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.japi.function.Procedure;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.FileIO;
import akka.stream.javadsl.Source;
import akka.util.ByteString;

import java.math.BigInteger;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.temporal.TemporalUnit;

public class TestStream {


    public static void main(String[] args) {

        ActorSystem actorSystem = ActorSystem.create("stream-test");
        ActorMaterializer actorMaterializer = ActorMaterializer.create(actorSystem);

        Runnable terminate=actorSystem::terminate;
        Procedure<String> sysout = System.out::println;


        //basic processing
//        Source.range(0, 50)
//                .reduce((x,y) -> x+y)
//                .runForeach(i -> System.out.println("got number " + i), actorMaterializer)
//                .thenRun(actorSystem::terminate);


//        write to files
//        Source
//                .range(1, 5)
//                .scan(BigInteger.ONE, (x, y) -> x.multiply(BigInteger.valueOf(y)))
//                .map(x-> x.multiply(BigInteger.valueOf(2)))
//                .map(num -> ByteString.fromString(num.toString() + "\n"))
//                .runWith(FileIO.toPath(Paths.get("fact.txt")),actorMaterializer)
//                .thenRun(actorSystem::terminate);


        Source.range(1, 7)
                .scan(BigInteger.ONE,(x,y) -> x.multiply(BigInteger.valueOf(y)))
                .zipWith(Source.range(1,7), (num, idx) -> String.format("%d! = %s", idx, num))
                .throttle(1,Duration.ofSeconds(3))
                .map(str-> ByteString.fromString(str+"\n")) // required by runwith
                .runWith(FileIO.toPath(Paths.get("out.txt")),actorMaterializer)
                .thenRun(terminate);

    }



}
