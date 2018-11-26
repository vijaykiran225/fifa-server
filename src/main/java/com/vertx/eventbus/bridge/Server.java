package com.vertx.eventbus.bridge;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.PermittedOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * A {@link io.vertx.core.Verticle} which bridges the browser to the  @{link EventBus}. The client setup is using the
 * common js module.
 *
 * @author <a href="https://github.com/pmlopes">Paulo Lopes</a>
 */
public class Server extends AbstractVerticle {

  

  @Override
  public void start() throws Exception {

    Router router = Router.router(vertx);


    // Allow events for the designated addresses in/out of the event bus bridge
    BridgeOptions opts = new BridgeOptions()
        .addInboundPermitted(new PermittedOptions().setAddress("feed"))
        .addOutboundPermitted(new PermittedOptions().setAddress("feed"));

    // Create the event bus bridge and add it to the router.
    SockJSHandler ebHandler = SockJSHandler.create(vertx).bridge(opts);
    router.route("/eventbus/*").handler(ebHandler);

    router.get("/post-data").handler(getRoutingContextHandler());
    // Create a router endpoint for the static content.
    router.route().handler(StaticHandler.create());

    // Start the web server and tell it to use the router to handle requests.
    vertx.createHttpServer().requestHandler(router::accept).listen(8080);

    EventBus eb = vertx.eventBus();

    vertx.setPeriodic(1000l, t -> {
      // Create a timestamp string
      String timestamp = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).format(Date.from(Instant.now()));
      JsonObject j= new JsonObject().put("content", timestamp).put("lang","server");
      eb.send("feed", j);
    });
  }

  private Handler<RoutingContext> getRoutingContextHandler() {
    return event -> {
      JsonObject j= new JsonObject().put("content", "External call").put("lang","EXT");

      vertx.eventBus().send("feed",j);
      event.response().end("tried");
    };
  }
}