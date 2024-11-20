package ru.mastkey.lesson15;

import lombok.SneakyThrows;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import ru.mastkey.lesson15.config.RabbitConsumer;
import ru.mastkey.lesson15.config.RabbitProducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
public abstract class RabbitBaseTest {
    protected final Integer PRODUCER_COUNT;
    protected final Integer CONSUMER_COUNT;
    private List<RabbitProducer> producers;
    private List<RabbitConsumer> consumers;
    private final String QUEUE_NAME = "test_queue";

    public RabbitBaseTest(Integer producerCount, Integer consumerCount) {
        this.PRODUCER_COUNT = producerCount;
        this.CONSUMER_COUNT = consumerCount;
    }

    @Setup(Level.Trial)
    public void setUp() throws IOException, TimeoutException {
        producers = new ArrayList<>();
        for (int i = 0; i < PRODUCER_COUNT; i++) {
            producers.add(new RabbitProducer(QUEUE_NAME));
        }

        consumers = new ArrayList<>();
        for (int i = 0; i < CONSUMER_COUNT; i++) {
            consumers.add(new RabbitConsumer(QUEUE_NAME));
        }
    }

    @Benchmark
    @SneakyThrows
    public void testProducerConsumer(Blackhole blackhole) throws IOException {
        producers.forEach(producer -> {
            try {
                var message = "tets";
                producer.send(message, QUEUE_NAME);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        consumers.forEach(consumer -> {
            try {
                var message = consumer.consumeMessage(QUEUE_NAME);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    @TearDown(Level.Trial)
    public void tearDown() throws IOException {
        for (RabbitProducer producerChannel : producers) {
            producerChannel.close();
        }
        for (RabbitConsumer consumerChannel : consumers) {
            consumerChannel.close();
        }
    }
}
