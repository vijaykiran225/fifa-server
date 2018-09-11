package com.vertx.kakfa;

import io.reactivex.Observable;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.kafka.client.producer.KafkaProducerRecord;
import io.vertx.kafka.client.producer.RecordMetadata;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyKafkaProducerVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.ACKS_CONFIG, "1");
        KafkaProducer<String, String> producer = KafkaProducer.create(vertx, config, String.class, String.class);

        List<Integer> we = IntStream.iterate(0, x -> x + 1).boxed().limit(50).collect(Collectors.toList());

        Random rd=new Random();

        Observable.fromIterable(we)
                .flatMap(integer ->
                        Observable.<Integer>just(integer).delay(rd.nextInt(2500), TimeUnit.MILLISECONDS)
                )
                .map(String::valueOf)
                .subscribe(e->{
                    this.sendMsg(e,producer);
                });

    }

    private void sendMsg(String content, KafkaProducer<String, String> producer) {

        KafkaProducerRecord<String, String> x = KafkaProducerRecord.create("fifa17", content);
        producer.write(x, done -> {

            if (done.succeeded()) {

                RecordMetadata recordMetadata = done.result();
                System.out.println("Message " + x.value() + " written on topic=" + recordMetadata.getTopic() +
                        ", partition=" + recordMetadata.getPartition() +
                        ", offset=" + recordMetadata.getOffset());
            } else {
                System.err.println("faile" + done.cause().getMessage());
            }

        });
    }

    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(new MyKafkaProducerVerticle());
    }
}
