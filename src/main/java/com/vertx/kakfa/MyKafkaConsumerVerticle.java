package com.vertx.kakfa;

import com.vertx.eventbusdemo.Producer;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.kafka.client.common.TopicPartition;
import io.vertx.kafka.client.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class MyKafkaConsumerVerticle extends AbstractVerticle {



    @Override
    public void start() {
        ch.qos.logback.classic.Logger x = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);

        x.setLevel(ch.qos.logback.classic.Level.ERROR);

        Properties config = new Properties();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "my_group");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");

        // use consumer for interacting with Apache Kafka
        KafkaConsumer<String, String> consumer = KafkaConsumer.create(vertx, config);
        consumer.handler(record->{
            System.out.println("Processing key=" + record.key() + ",value=" + record.value() +
                    ",partition=" + record.partition() + ",offset=" + record.offset());
            vertx.eventBus().send("chat1",record.value());
        });
        consumer.pollTimeout(10000);
        consumer.assign(new TopicPartition("fifa17",0));
    }

    public static void main(String[] args) {


        Vertx.clusteredVertx(new VertxOptions().setClustered(true), resp->{

            if (resp.succeeded()){
                Vertx vertx = resp.result();
                vertx.deployVerticle(new MyKafkaConsumerVerticle());
            }
            else {
                resp.cause().printStackTrace();
            }
        });
    }
}
