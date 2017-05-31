package FunctionalProgramming.Methodereferences;

import FunctionalProgramming.FuntionalInterfaces.MyFunctionalIntefaces.TriFunction;
import FunctionalProgramming.Model.Person;

import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by brahim on 5/28/17.
 */
public class ConstructorReference {

    public static  List<Person> map(List<String> names, Function<String, Person> toPerson){
        List<Person> result = new ArrayList<>();
        for(String name : names )
            result.add(toPerson.apply(name));
        return result;
    }


    public static void main(String[] args){

        Supplier<Person> supplier1 = Person::new ;
        Person p1 = supplier1.get();

        // wich is equivalent to
        Supplier<Person> supplier2 = () -> new Person();
        Person p2 = supplier2.get();


        /*
           In this example we gonna create a list of Person from a list of names;
         */

        List<String> names = Arrays.asList("Niven", "Cristian", "Chandal");

        //lambda solution ::
        List<Person> listPerson1  = map(names,s -> new Person(s) );

        //constructor reference solution ::
        List<Person> listPerson2 = map(names, Person::new);


        System.out.print(listPerson1);
        System.out.println(listPerson2);

        /*
        We saw how to transform zero-, one-, and two-argument constructors into constructor
        references. What would we need to do in order to use a constructor reference for a
        three-argument constructor such as Person(String, String, String)?

        Answer :: we can create our own generic functional interface (TriFunction) ::

         */


        //Using a lambda ::
        TriFunction<String, String, String, Person> triFunction1 = (firstName,lastName,adresse) ->new Person(firstName, lastName, adresse);


        //Using a reference constructor ::
        TriFunction<String, String, String, Person> triFunction2 = Person::new;





    }
}
