package FunctionalProgramming.Streams;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by brahim on 6/24/17.
 */
public class StreamFromFunctions {

    public static void main(String[] args){


        /*

        The Streams API provides two static methods to generate a stream from a function:
    Stream.iterate and Stream.generate. These two operations let you create what we call an infinite
    stream: a stream that doesn’t have a fixed size like when you create a stream from a fixed
    collection. Streams produced by iterate and generate create values on demand given a function
    and can therefore calculate values forever! It’s generally sensible to use limit(n) on such streams
    to avoid printing an infinite number of values.
         */


        Stream.iterate(1, n -> n+2)
                .limit(10)
                .forEach(System.out::println);

        /*
        Fibonnaci
         */
        /*
        The series of Fibonacci tuples is similar; you have a sequence of a number and its successor in
        the series: (0, 1), (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13, 21)....
         */

        Stream.iterate(new int[]{0,1}, t -> new int[]{t[1], t[0]+t[1]})
                .limit(10)
                .forEach(t-> System.out.println("("+t[0]+","+t[1]+")"));

        /*
        we could use a map to extract only the first element of each tuple:
         */

        Stream.iterate(new int[]{0,1}, t -> new int[]{t[1], t[0]+t[1]})
                .map(t -> t[0])
                .limit(10)
                .forEach(System.out::println);


        /*
        Similarly to the method iterate, the method generate lets you produce an infinite stream of
        values computed on demand. But generate doesn’t apply successively a function on each new
        produced value. It takes a lambda of type Supplier<T> to provide new values. Let’s look at an
        example of how to use it:
         */

        Stream.generate(Math::random);


        IntSupplier fib = new IntSupplier() {
            private int previous =0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.current+ this.previous;
                this.previous = current;
                this.current = nextValue;
                return oldPrevious;
            }


        };
        System.out.println("Fibonacci using generate  !!");
        IntStream.generate(fib).limit(10).forEach(System.out::println);

    }
}
