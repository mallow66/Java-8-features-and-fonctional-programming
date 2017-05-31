package Model;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by brahim on 5/15/17.
 */
public class RegisterPerson extends LinkedList<Person> {



    //insert some people on the current list for testing
    public  RegisterPerson(){
        add(new Person("Pembroke","Skrines",24,"Vila de Rei","351-(220)404-2844","pskrines1@jiathis.com"));
        add(new Person("Christophorus","Bourbon",41,"Ombarade","62-(705)752-4166","cbourbon3@apple.com"));
        add(new Person("Cristian","Van Son",14,"Mocun","86-(319)571-7780","cvansond@sogou.com"));
        add(new Person("Niven","De Andreis",24,"Torslanda","46-(695)568-7341","ndeandreisn@t.co"));
        add(new Person("Mill","Jumont",26,"Cikabuyutan Barat","62-(171)853-0184","mjumontp@sciencedirect.com"));
        add(new Person("Langsdon","Espinheira",53,"Volary","420-(831)489-1312","lespinheira1g@eepurl.com"));
        add(new Person("Chandal","Poytres",58,"Sarmanovo","7-(796)928-0612","cpoytres1l@imgur.com"));
    }


    public RegisterPerson filter(Predicate<Person> personPredicate){
        RegisterPerson output = new RegisterPerson();

        for(Person p : this){
            if(personPredicate.test(p))
                output.add(p);
        }
        return output;
    }


    @Override
    public String toString() {
        String str="[\n";
        for(Person p: this){
            str+=p.toString();
            str+="\n";
        }
        str+="]";

        return str;
    }
}
