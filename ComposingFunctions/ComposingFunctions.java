package FunctionalProgramming.ComposingFunctions;

import sun.rmi.server.InactiveGroupException;

import java.util.function.Function;

/**
 * Created by brahim on 5/28/17.
 */
public class ComposingFunctions {

    public static void main(String[] args){

        Function<Integer, Integer> f = x -> x+2;
        Function<Integer, Integer> g = y -> y*3;

        //in math we note z = g(f(x)) or z = (g o f)(x)
        Function <Integer, Integer> z = f.andThen(g);

        int result = z.apply(1);
        System.out.println(result);

        /*
        Wou can also use the method compose similarly to first apply the function given as argument to
        compose and then apply the function to the result. For example, in the previous example using
        compose, it would mean f(g(x)) instead of g(f(x)) using andThen:
         */

        Function<Integer, Integer> h = f.compose(g);
        result = h.apply(1);
        System.out.println(result);

    }
}
