package FunctionalProgramming.FuntionalInterfaces;
import FunctionalProgramming.Model.Person;
import FunctionalProgramming.Model.RegisterPerson;
import java.util.function.Consumer;

/**
 * Created by brahim on 5/28/17.
 */
public class ConsumerTest {


    public static void main(String[] args){


        /*
        The java.util.function.Consumer<T> interface defines an abstract method named accept that
        takes an object of generic type T and returns no result (void). You might use this interface when
        you need to access an object of type T and perform some operations on it.

        adding 2 years of age for each person in the register ::

     */

        RegisterPerson registerPerson = new RegisterPerson();
        Consumer<Person> consumer = p -> p.setAge(p.getAge() +2);

        System.out.println("Before :: ");
        System.out.println(registerPerson);

        registerPerson.forEach(consumer);
        System.out.println("After :: ");
        System.out.println(registerPerson);
    }





}
