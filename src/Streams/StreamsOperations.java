package Streams;

import Model.Dish;
import Model.RegisterDish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by brahim on 5/29/17.
 */
public class StreamsOperations {

    public static void main(String[] args){

        RegisterDish.fillMenu();
        List<Dish> menu = RegisterDish.getMenu();
        System.out.println(menu);

        List<String> names  =
                menu.stream()
                        .filter(d -> {
                                        System.out.println("Filtering .."+d.getName());
                                        return d.getCalorie()>300; }
                                        )
                        .map( d ->{
                            System.out.println("Mapping.."+d.getName());
                            return d.getName();
                        })
                        .limit(3)
                        .collect(toList());


        System.out.println(names);


        long count = menu.stream()
                .filter(d -> d.getCalorie()>300)
                .distinct()
                .count();

        System.out.println("Count ::" + count);



        /*

        To summarize, working with streams in general involves three items:
        - A data source (such as a collection) to perform a query on
        - A chain of intermediate operations that form a stream pipeline
        - A terminal operation that executes the stream pipeline and produces a result
         */

        Stream<Dish> s = menu.stream().filter(d -> d.getName().contains("a"));
        s.forEach(System.out::println);

        //filter all the vegetarian dishes ::

         menu.stream()
                 .filter(Dish::isVegetarian)
                .collect(toList())
                .forEach(System.out::println);


        //filter all the pair numbers with no repetition  ::
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);


        /*
        Streams support the skip(n) method to return a stream that discards the first n elements
         */

        menu.stream()
                .filter(d -> d.getCalorie()>300)
                .skip(3)
                .forEach(System.out::println);


        /*
        The first two meat dishes ::
         */

        System.out.println(" The first two meat dishes are ::  ");
        menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .forEach(System.out::println);



        List<String > words = Arrays.asList("Hello", "Bonjour");
       words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);


    }
}
