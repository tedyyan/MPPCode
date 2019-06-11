package lab8.prob2.a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lab8.prob2.Product;

public class PriceComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		
		return Double.valueOf(o1.getPrice()).compareTo(Double.valueOf(o2.getPrice()));
	}

	public static void main(String[] args) {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("Carpet", 23.0, 2));
		products.add(new Product("Air Condition", 523.0, 1));
		products.add(new Product("Fridge", 423.0, 21));
		products.add(new Product("Funiture", 223.0, 12));
		products.add(new Product("Chair", 123.0, 32));
		products.sort(new PriceComparator());
		System.out.print(products);
	}
}
