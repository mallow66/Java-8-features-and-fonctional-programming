package FunctionalProgramming.Streams;

import FunctionalProgramming.Model.Dish;
import FunctionalProgramming.Model.RegisterDish;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by brahim on 5/31/17.
 */
public class NumericStreams {

    public static void main(String[] args){

        RegisterDish.fillMenu();
        List<Dish> menu = RegisterDish.getMenu();


        /*
        we can calculate the number of calories in the menu as follows:
         */
       int calorieMenu =
        menu.stream()
                .map(d -> d.getCalorie())
                .reduce(0, Integer::sum);

       /*
        The problem with this code is that there’s an insidious boxing cost. Behind the scenes each
        Integer needs to be unboxed to a primitive before performing the summation. In addition,
        wouldn’t it be nicer if you could call a sum method directly as follows?
        */

       /*
        menu.stream()
               .map(Dish::getCalorie)
               .sum()
        */

       /*
       But this isn’t possible. The problem is that the method map generates a Stream<T>. Even
        though the elements of the stream are of type Integer, the Streams interface doesn’t define a
        sum method.
        */




       /*
       Primitive stream specializations
        */

       calorieMenu = menu.stream()
               .mapToInt(Dish::getCalorie)
                .sum(); // returns IntStream Object ::

        System.out.println("The calories on the menu are :"+ calorieMenu);

        /*
        Converting back to a stream of objects :
         */

        IntStream intStream =
                menu.stream()
                .mapToInt(Dish::getCalorie);

        Stream<Integer> toStream = intStream.boxed();



        /*
        Default values: OptionalInt
         */

        OptionalInt optionalMax =
                menu.stream()
                .mapToInt(Dish::getCalorie)
                .max();

        /*
        ou can now process the OptionalInt explicitly to define a default value if there’s no maximum:
         */

        int max = optionalMax.orElse(1);






        /*
        Numeric Ranges ::
         */
                System.out.println("Even Numbers   ::");

                IntStream.rangeClosed(1, 100)
                .filter(n -> n%2 == 0)
                .forEach(System.out::println);


        /*
         Putting numerical streams into practice: Pythagorean triples
        */

        System.out.println("Pythagorean triples");
         class PythagoreTriple{

             private Integer a, b, c;
             public PythagoreTriple(Integer a, Integer b){
                 this.a = a;
                 this.b = b;
                 this.c = (int)Math.sqrt(a*a+b*b);
             }

             @Override
             public String toString(){
                 return "("+a+","+b+","+c+"); ";
             }
        }

        System.out.println("Pythagorean triples assuming that a is known");

        int a1 = 100;

                 IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a1*a1+b*b)%1.0 == 0)
                .boxed()
                .map(b -> new PythagoreTriple(a1, b))
                         .forEach(System.out::println);


        System.out.println("A solution assuming that we must generate a and b");

        Stream<PythagoreTriple> p =
        IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap( a-> IntStream.rangeClosed(1,100)
                                .filter(b -> Math.sqrt(a*a + b*b)%1.0 == 0)
                                .mapToObj( b -> new PythagoreTriple(a, b))

                );


        p.forEach(System.out::println);



    }
}
