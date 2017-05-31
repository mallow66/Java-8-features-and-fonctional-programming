package Streams;

import Model.Dish;
import Model.RegisterDish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by brahim on 5/30/17.
 */
public class FindingAndMatching {

    public static void main(String[] args){

        RegisterDish.fillMenu();
        List<Dish> menu = RegisterDish.getMenu();
        /*
        Checking to see if a predicate matches at least one element
         */

        /*
        The anyMatch method can be used to answer the question “Is there an element in the stream
        matching the given predicate?” For example, you can use it to find out whether the menu has a
        vegetarian option:
         */

        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!");

        }

        /*
        Checking to see if a predicate matches all elements
         */

        if(menu.stream().allMatch(d -> d.getCalorie()<1000)){
            System.out.println("The menu is healthy ! ");
        }


        if(menu.stream().noneMatch(d -> d.getCalorie()>=1000)){
            System.out.println("The menu is healthy !! ");
        }


        /*
        Some operations don’t need to process the whole stream to produce a result. For example, say
        you need to evaluate a large boolean expression chained with and operators. You need only find
        out that one expression is false to deduce that the whole expression will return false, no matter
        how long the expression is; there’s no need to evaluate the entire expression. This is what
        short-circuiting refers to.
         */





        /*

        Fiding Elements ::
         */

        /*
        The findAny method returns an arbitrary element of the current stream. It can be used in
        conjunction with other stream operations. For example, you may wish to find a dish that’s
        vegetarian.
         */


        Optional<Dish> vegetarienDish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();


        vegetarienDish.ifPresent(System.out::print);


        /*
        The Optional<T> class (java.util.Optional) is a container class to represent the existence or
        absence of a value. In the previous code, it’s possible that findAny doesn’t find any element.
        Instead of returning null, which is well known for being error prone
         */



        /*
        Finding the first element ::
         */

        menu.stream()
                .filter(Dish::isVegetarian)
                .findFirst()
                .ifPresent(System.out::println);


        /*
        Finding the first square divisible by 3
         */

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);

        someNumbers.stream()
                .map(x -> x*x)
                .filter(x -> x%3 == 0)
                .findFirst()
                .ifPresent(System.out::println);







    }
}
