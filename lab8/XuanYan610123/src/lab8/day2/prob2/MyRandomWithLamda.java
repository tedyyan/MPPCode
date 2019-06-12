package lab8.day2.prob2;

import java.util.function.Supplier;

public class MyRandomWithLamda {
	public Double getRand() {
		Supplier<Double> my = () -> Math.random();
		return my.get();

	}

	public static void main(String[] args) {
		MyRandomWithLamda instance = new MyRandomWithLamda();
		System.out.print(instance.getRand());
	}
}
