package ru.mastkey.lesson15.load_balancing_test;

import ru.mastkey.lesson15.KafkaBaseTest;

public class KafkaLBTest extends KafkaBaseTest {
    public KafkaLBTest() {
        super(3, 1);
    }
}
