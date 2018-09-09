package com.test.springboot.init;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

//@Component
public class JerseyConfig /*extends ResourceConfig*/ {

    public JerseyConfig() {

        registerEndpoints();

    }

    private void registerEndpoints() {

//        packages("com.test.springboot");
    }

}

