package ru.mastkey.lesson15.multiple_consumers_test;

import ru.mastkey.lesson15.KafkaBaseTest;

public class KafkaMCTest extends KafkaBaseTest {
    public KafkaMCTest() {
        super(1, 3);
    }
}
