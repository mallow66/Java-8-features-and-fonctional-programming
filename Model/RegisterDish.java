package FunctionalProgramming.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brahim on 5/29/17.
 */
public class RegisterDish {

    private static List<Dish> menu;


    public static void fillMenu(){
        menu = new ArrayList<>();

        menu.add(new Dish("pork", false, 800,Dish.Type.MEAT));
        menu.add(new Dish("beef", false, 700, Dish.Type.MEAT));
        menu.add(new Dish("chicken", false, 400, Dish.Type.MEAT));
        menu.add(new Dish("french fries", true, 530, Dish.Type.OTHER));
        menu.add(new Dish("rice", true, 350, Dish.Type.OTHER));
        menu.add(new Dish("season fruit", true, 120, Dish.Type.OTHER));
        menu.add(new Dish("pizza", true, 550, Dish.Type.OTHER));
        menu.add(new Dish("prawns", false, 300, Dish.Type.FISH));
        menu.add(new Dish("salmon", false, 450, Dish.Type.FISH));
    }

    public static List<Dish> getMenu() {
        return menu;
    }


}
