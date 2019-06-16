package lab9.ShuhanSun.prob9;
import java.util.*;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type { MEAT, FISH, OTHER }

    @Override
    public String toString() {
        return name;
    }

    public static final List<Dish> menu =
            Arrays.asList( new Dish("pork", false, 800, Type.MEAT),
                           new Dish("beef", false, 700, Type.MEAT),
                           new Dish("chicken", false, 400, Type.MEAT),
                           new Dish("french fries", true, 530, Type.OTHER),
                           new Dish("rice", true, 350, Type.OTHER),
                           new Dish("season fruit", true, 120, Type.OTHER),
                           new Dish("pizza", true, 550, Type.OTHER),
                           new Dish("prawns", false, 400, Type.FISH),
                           new Dish("salmon", false, 450, Type.FISH));


    public static void main(String[] args) {
        /*
        * a. Is there any Vegetarian meal available ( return type boolean)
            b. Is there any healthy menu have calories less than 1000 ( return type boolean)
            c. Is there any unhealthy menu have calories greater than 1000 ( return type boolean)
            d. find and return the first item for the type of MEAT( return type Optional<Dish>)
            e. calculateTotalCalories() in the menu using reduce. (return int)
            f. calculateTotalCaloriesMethodReference()in the menu using MethodReferences. (return int)
        * */
        //a
        System.out.println(menu.stream().anyMatch(dish -> dish.isVegetarian()));
        //b
        System.out.println(menu.stream().anyMatch(dish -> dish.getCalories() < 1000));
        //c
        System.out.println(menu.stream().anyMatch(dish -> dish.getCalories() > 1000));
        //d
        System.out.println(menu.stream().filter(dish -> dish.getType().equals(Type.MEAT)).findFirst());
        //e
        System.out.println(calculateTotalCalories());
        //f
        System.out.println(calculateTotalCaloriesMethodReference());

    }

    public static int calculateTotalCalories(){
        Optional<Integer> totalCalories = menu.stream().map(dish -> dish.getCalories()).reduce((a, b) -> a + b);
        return totalCalories.get();
    }
    public static int calculateTotalCaloriesMethodReference(){
        return menu.stream().map(Dish::getCalories).reduce((a, b) -> a + b).get();
    }

}