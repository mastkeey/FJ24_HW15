package ru.mastkey.lesson15.config;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitConfig {
    public static Connection createConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5673);
        factory.setUsername("admin");
        factory.setPassword("admin");
        return factory.newConnection();
    }

    public static Channel createChannel(Connection connection, String queue) throws IOException {
        Channel channel = connection.createChannel();
        channel.queueDeclare(queue, true, false, false, null);
        return channel;
    }
}