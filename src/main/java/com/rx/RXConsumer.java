package com.rx;


import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RXConsumer {

    public static void main(String[] args) throws InterruptedException {

        BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
        Reader.consoleInput(x)
                .map(s -> {
                    System.out.println("mapping from lines  in thread"+Thread.currentThread().getName());
                    return Integer.parseInt(s);
                })
                .observeOn(Schedulers.single())
                .flatMap(num-> Fibo.fibonacci().take(num).buffer(num))
                .blockingSubscribe(x1 -> {
                    System.out.println(x1);
                    System.out.println("blocking subs in thread"+Thread.currentThread().getName());

                });

    }

    static Observable<Integer> emitter() {

        List<Integer> numbers = IntStream.range(0, 10).boxed().collect(Collectors.toList());

        Random random = new Random();
        return Observable.fromIterable(numbers)
                .concatMap(num ->
                        Observable
                        .just(random.nextInt(15))
                        .delay(random.nextInt(500), TimeUnit.MILLISECONDS))
                .doOnComplete(() -> System.out.println("received complete"))
                .doOnDispose(() -> System.out.println("received dispose"));
    }
}
