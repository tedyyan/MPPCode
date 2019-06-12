package lab8.day2.prob4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MySort {
	public static void main(String[] args) {
		String[] names = {"Alexis", "Tim", "Kyleen", "KRISTY"};
		List<String> kStream = Stream.of(names).sorted(String::compareToIgnoreCase).collect(Collectors.toList());
		System.out.println(kStream);
	}
}
