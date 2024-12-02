package ru.mastkey.lesson15.stress_test;

import ru.mastkey.lesson15.RabbitBaseTest;

public class RabbitStressTest extends RabbitBaseTest {
    public RabbitStressTest() {
        super(10, 10);
    }
}
