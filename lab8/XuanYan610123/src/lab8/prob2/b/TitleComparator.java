package lab8.prob2.b;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lab8.prob2.Product;

public class TitleComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}
	public static void main(String[] args) {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("Carpet", 23.0, 2));
		products.add(new Product("Air Condition", 523.0, 1));
		products.add(new Product("Fridge", 423.0, 21));
		products.add(new Product("Funiture", 223.0, 12));
		products.add(new Product("Chair", 123.0, 32));
		products.sort(new TitleComparator());
		System.out.print(products);
	}
}
