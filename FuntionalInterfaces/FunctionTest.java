package FuntionalInterfaces;

import Model.Person;
import Model.RegisterPerson;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by brahim on 5/28/17.
 */
public class FunctionTest {

    public static <T, R> List<R> map(List<T> list, Function<T,R>function){
        List<R> result = new LinkedList<>();

        for (T one :list)
            result.add(function.apply(one));
        return result;
    }

    public static void main(String[] args){

        /*
        The java.util.function.Function<T, R> interface defines an abstract method named apply that
        takes an object of generic type T as input and returns an object of generic type R.
         */

        /*
        this function will take the age for each person, add +2 and return the ages in a list.
         */

        RegisterPerson r = new RegisterPerson();
        Function<Person, Integer> personFunction  = p -> p.getAge()+2 ;

        List<Integer> ages = map(r, personFunction);


        System.out.println(r);
        System.out.print(ages);
    }
}
