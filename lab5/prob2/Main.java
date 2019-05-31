package lab5.prob2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Figure> list = new ArrayList<Figure>();
		list.add(new Circle(1));
		list.add(new Triangle(2, 10));
		list.add(new Rectangle(5, 4));
		double sum = 0;
		for (Figure figure : list) {
			System.out.println(figure.computeArea());
			sum += figure.computeArea();
		}
		System.out.println("Sum of Areas = " + sum);
	}
}
