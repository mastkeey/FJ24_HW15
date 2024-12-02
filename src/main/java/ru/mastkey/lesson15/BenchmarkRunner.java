package ru.mastkey.lesson15;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include("ru\\.mastkey\\.lesson15\\..*")
                .forks(1)
                .warmupIterations(10)
                .measurementIterations(5)
                .output("benchmark.txt")
                .build();

        new Runner(opt).run();
    }
}