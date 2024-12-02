package ru.mastkey.lesson15.multiple_consumers_test;

import ru.mastkey.lesson15.RabbitBaseTest;

public class RabbitMCTest extends RabbitBaseTest {
    public RabbitMCTest() {
        super(1, 3);
    }
}
