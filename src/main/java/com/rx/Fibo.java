package com.rx;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Fibo {

    static Observable<Integer> fibonacci() {
        return Observable.<Integer>create(sub -> {
            int a = 0;
            int b = 1;

            sub.onNext(a);
            sub.onNext(b);
            while (!sub.isDisposed()) {
                System.out.println("fib in thread"+Thread.currentThread().getName());
                int c = a + b;
                a = b;
                b = c;
                sub.onNext(c);
            }
        });//.subscribeOn(Schedulers.computation());
    }
}
