package ru.mastkey.lesson15.load_balancing_test;

import ru.mastkey.lesson15.RabbitBaseTest;

public class RabbitLBTest extends RabbitBaseTest {
    public RabbitLBTest() {
        super(3, 1);
    }
}
