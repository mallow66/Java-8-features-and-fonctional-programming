package FunctionalProgramming.Streams;

import FunctionalProgramming.Model.Dish;
import FunctionalProgramming.Model.RegisterDish;

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



         /*

      Using flatMap to find the unique characters from a list of
      words
        */
        List<String > words = Arrays.asList("Hello", "World");
       words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);



       /*
        return a list of the square of each number in the list bellow
        */
       System.out.println("List of squares :: ");
       List<Integer> squares = Arrays.asList(1, 2, 3, 4, 5, 6);
       squares.stream()
               .map( n -> n*n)
               .forEach(System.out::println);

       /*
       Given two lists of numbers, how would you return all pairs of numbers? For example, given a
        list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For
        simplicity, you can represent a pair as an array with two elements.
        Answer:
        */

       List<Integer> numbers1 = Arrays.asList(1, 2, 3);
       List<Integer> numbers2 = Arrays.asList(3, 4);






    }
}
