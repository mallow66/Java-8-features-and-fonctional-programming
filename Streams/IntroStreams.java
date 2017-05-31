package FunctionalProgramming.Streams;

import FunctionalProgramming.FuntionalInterfaces.MyFunctionalIntefaces.StringLengthInteface;
import FunctionalProgramming.Model.Dish;
import FunctionalProgramming.Model.RegisterDish;
import FunctionalProgramming.Model.RegisterPerson;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by brahim on 5/29/17.
 */
public class IntroStreams {


    public static void main(String[] args){


        RegisterDish.fillMenu();
        List<Dish> menu  = RegisterDish.getMenu();


        List<String> threeHighcaloricDishName  =
                menu.stream()
                .filter(d -> d.getCalorie()>300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());



        //s.forEach(System.out::println);

        /*
        If you uncomment the line bellow, we will have an exception with the message ::
        stream has already been operated upon or closed

        So let's keep in mind that we can consume a stream only once!
         */

        List<String> dishes = Arrays.asList("Fish", "Meat", "Vegetarian");
        Stream<String> s = dishes.stream();
        s.forEach(System.out::println);


        /*
        External vs. internal iteration
         */

        // Collections: external iteration with a for-each loop
        List<String> dishesNames = new ArrayList<>();
        for(Dish d : menu)
            dishesNames.add(d.getName());

        //Collections: external iteration using an iterator behind the scenes
        dishesNames.clear();
        Iterator<Dish> iterator  = menu.iterator();
        while (iterator.hasNext())
            dishesNames.add(iterator.next().getName());



        //Streams: internal iteration ::
        dishesNames.clear();
        dishesNames =
                menu.stream()
                .map(Dish::getName)
                .collect(toList());


        System.out.println(menu);
        System.out.print(dishesNames);
    }





}
