package lab8.day2.prob4;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MySort {
	public static void main(String[] args) {
		String[] names = {"Alexis", "Tim", "Kyleen", "KRISTY"};
		Arrays.sort(names,String::compareToIgnoreCase);
		System.out.print(Stream.of(names).collect(Collectors.joining(" ")));
	}
}
