package lab8Day2.ShuhanSun.q3;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana","Orange","Cherries","blums");
        fruits.forEach((e)->System.out.println(e));
        fruits.forEach(System.out::println);
    }
}
