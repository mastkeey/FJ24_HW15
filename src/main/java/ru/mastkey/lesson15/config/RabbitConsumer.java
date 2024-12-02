package ru.mastkey.lesson15.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RabbitConsumer {
    private final Connection connection;
    private final Channel channel;

    public RabbitConsumer(String queue) throws IOException, TimeoutException {
        connection = RabbitConfig.createConnection();
        channel = RabbitConfig.createChannel(connection, queue);
    }

    public String consumeMessage(String queue) throws IOException {
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
        };

        return channel.basicConsume(queue, true, deliverCallback, consumerTag -> {
        });
    }

    public String consumeMessageWithAck(String queueName) throws IOException {
        var delivery = channel.basicGet(queueName, false);
        if (delivery != null) {
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            return new String(delivery.getBody());
        }
        return null;
    }

    public void close() {
        try {
            if (channel != null) {
                channel.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
