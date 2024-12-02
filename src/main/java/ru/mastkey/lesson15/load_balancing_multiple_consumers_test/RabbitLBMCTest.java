package ru.mastkey.lesson15.load_balancing_multiple_consumers_test;

import ru.mastkey.lesson15.RabbitBaseTest;

public class RabbitLBMCTest extends RabbitBaseTest {
    public RabbitLBMCTest() {
        super(3, 3);
    }
}
