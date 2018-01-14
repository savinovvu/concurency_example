package main.java.ru.inbox.savinov_vu.f_paralelReactiveStream.reducing;

import java.util.*;
import java.util.stream.DoubleStream;

public class DoubleGenerator {

    public static List<Double> generateDoubleList(int size, int max) {
        Random random = new Random();
        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            double value = random.nextDouble() * max;
            numbers.add(value);
        }
        return numbers;
    }

    public DoubleStream generateStreamFromList(List<Double> list) {
        DoubleStream.Builder builder = DoubleStream.builder();
        for (Double number :list) {
            builder.add(number);
        }
        return builder.build();
    }
}
