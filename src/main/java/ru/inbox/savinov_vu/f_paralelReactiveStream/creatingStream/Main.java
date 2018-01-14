package main.java.ru.inbox.savinov_vu.f_paralelReactiveStream.creatingStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("From a collection:");
        List<Person> people = PersonGenerator.generatePersonList(10000);
        Stream<Person> personStream = people.parallelStream();
        System.out.println("Number of persons: " + people.size());
        System.out.println();

        System.out.println("From a Supplier:");
        Supplier<String> supplier = new MySupplier();
        Stream<String> generatorStream = Stream.generate(supplier);
        generatorStream.parallel().limit(10).forEach(System.out::println);
        System.out.println();

        System.out.println("From a predefined set of elements");
        Stream<String> elementsStream = Stream.of("Peter", "John", "Mary");
        elementsStream.parallel().forEach(System.out::println);

        System.out.println();
        System.out.println("From a File");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/log.txt"));) {
            Stream<String> fileLines = bufferedReader.lines();
            System.out.println("Number of lines in the file: " + fileLines.parallel().count());
            System.out.println("***********************************************");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            Stream<Path> directoryContent = Files.list(Paths.get(System.getProperty("user.home")));
            System.out.println("Number of files and folders: "+ directoryContent.parallel().count());
            directoryContent.close();
            System.out.println("*******************");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("From an Array");
        String array[]={"1","2","3","4","5"};
        Stream<String> streamFromArray = Arrays.stream(array);
        streamFromArray.parallel().forEach(System.out::print);
        System.out.println();
        Random random = new Random();
        DoubleStream doubleStream = random.doubles(10);
        double asDouble = doubleStream.parallel().peek(d -> System.out.print( d +" : ")).average().getAsDouble();
        System.out.println("average - " + asDouble);
        System.out.println("Concatenating streams");
        Stream<String> stream1 = Stream.of("1", "2", "3", "4");
        Stream<String> stream2 = Stream.of("5", "6", "7", "8");
        Stream<String> concat = Stream.concat(stream1, stream2);
        concat.parallel().forEach(s-> System.out.print(s +" : "));
    }
}
