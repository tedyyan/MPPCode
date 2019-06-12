package lab8Day2.ShuhanSun.q4;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] names = {"Alexis", "Tim", "Kyleen", "KRISTY"};
        Arrays.stream(names).sorted(String::compareToIgnoreCase).forEach(System.out::println);
    }
}
