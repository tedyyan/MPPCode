package lab8.day2.prob2;

import java.util.function.Supplier;

public class MyRandomWithMethodReference {
	public Double getRand() {
			Supplier<Double> my = Math::random;
		 return my.get();

	}
	public static void main(String[] args) {
		MyRandomWithMethodReference instance = new MyRandomWithMethodReference();
		System.out.print(instance.getRand());
	}
}
