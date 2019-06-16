package lab9.ShuhanSun;

import java.util.Optional;
import java.util.stream.Stream;

public class Prob1 {
    public static void main(String[] args) {
        	/*
	 * 1. you have a stream of strings called stringstream consisting of the values “bill”, “thomas”, and “mary”.
	 * write the one line of code necessary to print this stream to the console so that the output looks like this:
bill, thomas, mary
*/

        Optional<String> r1 = Stream.of("Bill", "Thomas", "Mary").reduce((a, b) -> a + ", " + b);
        System.out.println(r1.get());
    }
}
