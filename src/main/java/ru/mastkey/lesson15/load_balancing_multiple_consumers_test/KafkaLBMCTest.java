package ru.mastkey.lesson15.load_balancing_multiple_consumers_test;

import ru.mastkey.lesson15.KafkaBaseTest;

public class KafkaLBMCTest extends KafkaBaseTest {
    public KafkaLBMCTest() {
        super(3, 3);
    }
}
