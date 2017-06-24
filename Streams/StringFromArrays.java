package FunctionalProgramming.Streams;

import FunctionalProgramming.Model.Dish;
import FunctionalProgramming.Model.RegisterDish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by brahim on 6/23/17.
 */
public class StringFromArrays {

    public static void main(String[] args){

        int[] numbers = {1,3,20, 2, 3};


        Stream<Integer> streamFromArray  = Arrays.stream(numbers).boxed();
        streamFromArray.forEach(System.out::println);
    }
}
