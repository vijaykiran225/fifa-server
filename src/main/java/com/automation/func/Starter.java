package com.automation.func;

import io.reactivex.Observable;

import javax.ws.rs.NotFoundException;
import java.util.concurrent.TimeUnit;

public class Starter {


    /**
     * create observable retries from the beginning
     *
     * just retries from the first operator !
     * @param args
     */
    public static void main(String[] args)  {
        step5("start test");

        Observable.<String>create(subs->{
            String x = step1();
                subs.onNext(x);
                subs.onComplete();
        })

                .map(Starter::step2)
                .timeout(5,TimeUnit.SECONDS)
                .map(Starter::step3)
                .timeout(3,TimeUnit.SECONDS)
                .map(Starter::step4)
                .retry(3)
                .blockingSubscribe(
                        Starter::step5,
                        err -> {
                            System.err.println("received faliure");//throw skip exception if needed to skip tests
                        },
                        () -> System.out.println("all processing complete")); // done

        System.out.println("end test");
    }

    private static void step5(String s) {
        System.out.println(" got from observer "+s);
    }

    private static String step1() {
        System.out.println("at the start of method 1");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("at the end of method 1");

//        System.out.println("about to throw exec");
//        throw new RuntimeException();
        return "some output from step 1";
    }

    private static String step2(String input) {
        System.out.println("at the start of method 2");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         System.out.println("at the end of method 2");
         return input+"some output  from step 2";
    }

    private static String step3(String input) {
        System.out.println("at the start of method 3");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        System.out.println("about to throw exec");
//        throw new RuntimeException("hello");

        System.out.println("at the end of method 3");
        return input + "some output from step 3";
    }

    private static String step4(String input) {
        System.out.println("at the start of method 4");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("at the end of method 4");
        return input + "some output from step 4";
    }
}