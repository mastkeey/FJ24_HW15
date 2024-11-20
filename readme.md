### Результаты тестирования
```
Benchmark                                                                            Mode  Cnt     Score     Error  Units
r.m.l.load_balancing_multiple_consumers_test.KafkaLBMCTest.kafkaProducersConsumers  thrpt    5     4,932 ±   0,029  ops/s
r.m.l.load_balancing_multiple_consumers_test.RabbitLBMCTest.testProducerConsumer    thrpt    5    93,192 ±  83,914  ops/s
r.m.l.load_balancing_test.KafkaLBTest.kafkaProducersConsumers                       thrpt    5  3938,997 ± 102,283  ops/s
r.m.l.load_balancing_test.RabbitLBTest.testProducerConsumer                         thrpt    5   351,842 ± 181,497  ops/s
r.m.l.multiple_consumers_test.KafkaMCTest.kafkaProducersConsumers                   thrpt    5     4,833 ±   0,017  ops/s
r.m.l.multiple_consumers_test.RabbitMCTest.testProducerConsumer                     thrpt    5    85,572 ±  50,722  ops/s
r.m.l.simple_test.KafkaSimpleTest.kafkaProducersConsumers                           thrpt    5  4341,344 ± 346,384  ops/s
r.m.l.simple_test.RabbitSimpleTest.testProducerConsumer                             thrpt    5   293,075 ± 222,366  ops/s
r.m.l.stress_test.KafkaStressTest.kafkaProducersConsumers                           thrpt    5     1,096 ±   0,003  ops/s
r.m.l.stress_test.RabbitStressTest.testProducerConsumer                             thrpt    5    26,074 ±  11,924  ops/s
```
### Краткий вывод

На основе проведенных тестов можно сделать следующие выводы по тестовым сценариям:
- 1 продюсер и 1 консюмер: Лучше всего подходит Kafka благодаря высокой производительности и минимальной задержке. 
- 3 продюсера и 1 консюмер: Лучше всего подходит Kafka, так как показывает наивысшую производительность.
- 1 продюсер и 3 консюмера: Лучше всего подходит RabbitMQ благодаря механизму предварительной выборки сообщений.
- 3 продюсера и 3 консюмера: Лучше всего подходит RabbitMQ, так как она справляется с балансировкой нагрузки лучше.
- 10 продюсеров и 10 консюмеров: Оба брокера показывают снижение производительности, но RabbitMQ лучше обрабатывает высокие нагрузки.
