package ru.mastkey.lesson15.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitProducer {
    private final Connection connection;
    private final Channel channel;

    public RabbitProducer(String queue) throws IOException, TimeoutException {
        connection = RabbitConfig.createConnection();
        channel = RabbitConfig.createChannel(connection, queue);
    }

    public void send(String message, String queue) throws IOException {
        channel.basicPublish("", queue, null, message.getBytes());
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
