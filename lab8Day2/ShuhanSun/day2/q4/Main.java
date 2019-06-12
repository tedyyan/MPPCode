package lab8Day2.ShuhanSun.q4;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] names = {"Alexis", "Tim", "Kyleen", "KRISTY"};
        Arrays.sort(names, String::compareToIgnoreCase);
        
        Arrays.stream(names).forEach(System.out::println);
    }
}
