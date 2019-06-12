package lab8.day2.prob2;

import java.util.function.Supplier;

public class MyRandomWithInner {
	public Double getRand() {
		Supplier<Double> my = new Supplier<Double>() {

			@Override
			public Double get() {
				return Math.random();
			}
		};
		return my.get();

	}

	public static void main(String[] args) {
		MyRandomWithInner instance = new MyRandomWithInner();
		System.out.print(instance.getRand());
	}
}
