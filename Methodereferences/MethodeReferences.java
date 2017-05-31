package Methodereferences;
import FuntionalInterfaces.MyFunctionalIntefaces.StringLengthInteface;
import Model.Person;
import Model.RegisterPerson;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * Created by brahim on 5/28/17.
 */
public class MethodeReferences {

    public static void main(String[] args){


        /*
        There are three main kinds of method references:
        1. A method reference to a static method (for example, the method parseInt of Integer, written
        Integer::parseInt)
        2. A method reference to an instance method of an arbitrary type (for example, the method
        length of a String, written String::length)
        3. A method reference to an instance method of an existing object (for example, suppose you
        have a local variable expensiveTransaction that holds an object of type Transaction, which
        supports an instance method getValue; you can write expensiveTransaction::getValue)
         */

        /*
        Method references let you reuse existing method definitions and pass them just like lambdas. In
        some cases they appear more readable and feel more natural than using lambda expressions.
         */




        RegisterPerson r = new RegisterPerson();

        /*
        Let's take an example of sorting the register using at the first time a lamba expression,
        and after that, using a method reference.
         */

        Comparator<Person> lambaComparator = (p1, p2) -> p1.getAge().compareTo(p2.getAge());
        r.sort(lambaComparator);

        Comparator<Person> methodReferenceComparator = Comparator.comparing(Person :: getAge);
        r.sort(methodReferenceComparator);


        //example of case 1   ::
        Function<String, Integer> stringToInteger1 = s -> Integer.parseInt(s);
        Function<String, Integer> stringToInteger2 = Integer::parseInt;


        //example of case 2 ::
        StringLengthInteface lengthLambda = s -> s.length();
        StringLengthInteface lengthReference = String::length;


        Function<Person, Integer> functionLambda = p -> p.getAge();
        Function<Person, Integer> functionReference = Person::getAge;


        BiPredicate<RegisterPerson, Person> personsPredicate = (list, person) -> list.contains(person);
        BiPredicate<RegisterPerson, Person> personReferencePredicate = RegisterPerson::contains;






    }
}
