package ru.mastkey.lesson15.stress_test;

import ru.mastkey.lesson15.KafkaBaseTest;

public class KafkaStressTest extends KafkaBaseTest {
    public KafkaStressTest() {
        super(10, 10);
    }
}
