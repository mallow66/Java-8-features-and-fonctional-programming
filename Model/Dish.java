package FunctionalProgramming.Model;

/**
 * Created by brahim on 5/29/17.
 */
public class Dish {

    private String name;
    private boolean vegetarian;
    private int calorie;
    public  Type type;

    public enum Type {
        MEAT, FISH, OTHER
    }

    public Dish(String name, boolean vegetarian, int calorie, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calorie = calorie;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }
}
