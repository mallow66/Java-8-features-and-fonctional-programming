package FunctionalProgramming.Streams;

import FunctionalProgramming.Model.Dish;
import FunctionalProgramming.Model.RegisterDish;

import java.util.Arrays;
import java.util.List;

/**
 * Created by brahim on 5/30/17.
 */
public class Reducing {

    public static void main(String[] args){

        RegisterDish.fillMenu();
        List<Dish> menu  = RegisterDish.getMenu();


        /*
        Reducing
         */

        //the sum of a list of integers ::
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer sum = someNumbers.stream()
                .reduce(0, (a,b) -> a+b);
        System.out.println("The sum is ::"+ sum);

        /*
        Or
         */

        sum = someNumbers.stream()
                .reduce(0, Integer::sum);

        /*
        There’s also an overloaded variant of reduce that doesn’t take an initial value, but it returns an
        Optional object:
         */

        sum = someNumbers.stream()
                .reduce(Integer::sum)
                .get();

        /*
        Why does it return an Optional<Integer>? Consider the case when the stream contains no
        elements. The reduce operation can’t return a sum because it doesn’t have an initial value. This
        is why the result is wrapped in an Optional object to indicate that the sum may be absent.
         */


        /*
        Minimum and maximum ::
         */

       int max =  someNumbers.stream()
                .reduce(0, (a, b) -> Integer.max(a, b));

       System.out.println("Le maximum de la liste est :: "+ max);

       /*
       Or just using the method reference of Integer :: max :
        */

       max = someNumbers.stream()
               .reduce(0, Integer::max);

       //minimum ::

        int min = someNumbers.stream()
                .reduce(0, (a, b) -> Integer.min(a, b));

        /*
        Or
         */

        min = someNumbers.stream()
                .reduce(0, Integer::min);



        /*
        How would you count the number of dishes in a stream using the map and reduce methods?
         */

        int numberOfDishes = menu.stream()
                .map(d -> 1)
                .reduce(0, Integer::sum);

        /*
        A chain of map and reduce is commonly known as the map-reduce pattern, made famous by
        Google’s use of it for web searching because it can be easily parallelized.
         */








    }
}
