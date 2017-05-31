package FunctionalProgramming.FuntionalInterfaces;

import FunctionalProgramming.Model.Person;
import FunctionalProgramming.Model.RegisterPerson;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by brahim on 5/15/17.
 */
public class PredicateTest {


    public static void main(String[] args){


        RegisterPerson  r = new RegisterPerson();



        //using a lamba expression for the predicate parametrization ::
        //filter the people with the age greater than 20::

        Predicate<Person> predicateAge = p -> p.getAge() >= 20;
        List<Person> result = r.filter(predicateAge);
        System.out.print(result);


        //select the people with their first names begins with 'C' ::
        Predicate<Person> firstNameBeginWithCPredicate = p -> p.getFirstName().matches("C(.*)");
        List<Person> result2 = r.filter(firstNameBeginWithCPredicate);

        System.out.print(result2);
    }
}
