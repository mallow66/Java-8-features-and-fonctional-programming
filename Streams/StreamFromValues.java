package FunctionalProgramming.Streams;

import java.util.stream.Stream;

/**
 * Created by brahim on 6/23/17.
 */
public class StreamFromValues {

    public static void main(String[] args){

        /*
        You can create a stream with explicit values by using the static method Stream.of, which can
        take any number of parameters. For example, in the following code you create a stream of
        strings directly using Stream.of. You then convert the strings to uppercase before printing them
        one by one:
         */

        Stream<String> stringStream = Stream.of("Rabat", "Casablanca", "Paris")
                .map(String::toUpperCase);

        stringStream.forEach(System.out::println);

        /*
        we can also get an empty Stream
         */

        Stream<String> emptyStream = Stream.empty();
    }
}
