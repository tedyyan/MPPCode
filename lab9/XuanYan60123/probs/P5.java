package probs;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P5 {
	public static Stream<String> streamSection(Stream<String> stream, int m, int n) {
		
		
		return stream.map(x->x.substring(m,n+1));
		// Implement the code
	}

	public static void main(String[] args) {
		// Make three calls for the streamSection() method with different inputs // use
		// nextStream() method to supply the Stream input as a first argument in
		// streamSection() method
		System.out.print(P5.streamSection(nextStream(), 2, 2).collect(Collectors.joining(",")));
		
	}

	// support method for the main method -- for testing
	private static Stream<String> nextStream() {
		return Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii").stream();
	}
}
