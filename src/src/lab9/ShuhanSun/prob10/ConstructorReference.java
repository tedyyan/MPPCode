package lab9.ShuhanSun.prob10;

import lab9.ShuhanSun.prob7b.TriFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Flow;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

class Human {
    String name;
    int age;
    String gender;

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Human [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }
}

public class ConstructorReference {
    public static void main(String args[]) {
        Human[] list = {new Human("Joe", 35, "Male"), new Human("Jane", 45, "Female"), new Human("John", 30, "Male")};

        // Query 1  : Print only Female canditates names
        Arrays.stream(list)
                .filter(human -> human.getGender().equals("Female"))
                .map(Human::getName).forEach(System.out::println);

        // Query 2 : Cretae an objecy by choosing suitable Interface to the
        // specified constructors(Totally 3 constuctors)
        // using fouth type of Method Reference ClassName::new. Then print the object status
//        TriFunction<String, Integer, String, Human> createFunc =
        Function<String, Human> func1 = Human::new;
        BiFunction<String, Integer, Human> func2 = Human::new;
        TriFunction<String, Integer, String, Human> func3 = Human::new;
        System.out.println(func1.apply("Sun"));
        System.out.println(func2.apply("Sun", 22));
        System.out.println(func3.apply("Sun", 22, "Male"));

        // Query 3 : Count the male candidates whose age is more than 30
        long count = Arrays.stream(list)
                .filter(human -> human.getGender().equals("Male"))
                .filter(human -> human.getAge() > 30)
                .count();
        System.out.println(count);


    }


    private static Human get() {
        return new Human("Jok", 12, "Male");
    }
}
