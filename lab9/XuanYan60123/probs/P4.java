package probs;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P4 {
	public static void printSquares(int num) {
		IntStream ins = IntStream.iterate(1, x->(x+1)).limit(num).map(x->x*x);
		//ins.forEach(System.out::println);
		System.out.print(ins.boxed().map(x->x.toString()).collect(Collectors.joining(",")));
	}
	
	public static void main(String[] args) {
		
		P4.printSquares(10);
	}
}
