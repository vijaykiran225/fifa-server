package com.springboot.util;

public class LoggerUtil {

    public static final void logObject(Object contentToLog){
        System.out.println("content"+contentToLog.toString());
    }

    public static final void logObject(String messagae,Object contentToLog){
        System.out.println("Message : "+messagae);
        System.out.println("content"+contentToLog.toString());
    }
}
