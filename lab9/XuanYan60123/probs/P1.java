package probs;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class P1 {
	
	//stringStream
	public static void main(String[] args) {
		Stream<String> stringStream = Stream.of("Bill","Thomas","Mary");
		System.out.print(stringStream.collect(Collectors.joining(",")));
	}
}
