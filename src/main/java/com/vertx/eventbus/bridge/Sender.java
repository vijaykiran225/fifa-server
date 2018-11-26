package com.vertx.eventbus.bridge;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;

/*
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class Sender extends AbstractVerticle {



  @Override
  public void start() throws Exception {
    EventBus eb = vertx.eventBus();

    // Send a message every second

    vertx.setPeriodic(1000, v -> {
      JsonObject j=new JsonObject();
      j.put("lang","Java");
      j.put("content","Java ping !");
      eb.send("feed", j);

    });
  }
}
