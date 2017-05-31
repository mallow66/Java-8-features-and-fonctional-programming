package Streams;

import Model.Trader;
import Model.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by brahim on 5/31/17.
 */
public class TransactionQuiz {

    public static void main(String[] args){

        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        Trader raoul = new Trader("Raoul", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        /*
        1. Find all transactions in the year 2011 and sort them by value (small to high).
         */

        System.out.println("All the transactions in the year 2011 sorted by its value");
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::print);


        /*
        2. What are all the unique cities where the traders work?

         */

        System.out.println("All the unique cities where the traders work :");
        transactions.stream()
                .map(t -> t.getTrader())
                .map(tr -> tr.getCity())
                .distinct()
                .forEach(System.out::println);

        /*
        3. Find all traders from Cambridge and sort them by name.
         */

        System.out.println("All traders from Cambridge and sorted by name :");
        transactions.stream()
                .map(t -> t.getTrader())
                .distinct()
                .filter(tr -> tr.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);


        /*
        4. Return a string of all traders’ names sorted alphabetically.
         */
        System.out.println("a String of all traders names sorted alphabetically");
        String names =
        transactions.stream()
                .map(t -> t.getTrader())
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .map(tr -> tr.getName())
                .reduce((n1,n2 ) -> n1+" "+n2 )
                .get();

        System.out.println("Names are ::"+ names);

        /*
        5. Are any traders based in Milan?
         */

        boolean isThereSomeoneinMilan =
        transactions.stream()
                .map(t -> t.getTrader())
                .anyMatch(tr -> tr.getCity().equals("Milan"));

        if(isThereSomeoneinMilan) System.out.println("Yes there is someone in Milan");
        else System.out.println("No one is in Milan");


        /*
        6. Print all transactions’ values from the traders living in Cambridge.
         */

        System.out.println("All transactions values from the traders living in Cambridge");
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .forEach(System.out::println);

        /*
        7. What’s the highest value of all the transactions?
         */

        int max =
        transactions.stream()
                .map(t -> t.getValue())
                .reduce((Integer::max))
                .get();

        System.out.println("The highest value of all transactions is : "+ max);


        /*
        8. Find the transaction with the smallest value.
         */



       Transaction transaction =  transactions.stream()
                .reduce((t1, t2) -> t1.getValue()< t2.getValue() ? t1 : t2)
                .get();


       System.out.println("The transaction with the smallest value is :" + transaction);









    }
}
