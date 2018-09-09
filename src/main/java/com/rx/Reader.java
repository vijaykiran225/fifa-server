package com.rx;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.io.BufferedReader;

public class Reader {

    static Observable<String> consoleInput(BufferedReader reader) {

        return Observable.<String>create(sub -> {

            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println("reader in thread"+Thread.currentThread().getName());

                sub.onNext(line);
                if (sub.isDisposed()) {
                    break;
                }
            }
            sub.onComplete();
        }).subscribeOn(Schedulers.io());
    }

}
