package lab8.prob2.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lab8.prob2.Product;
public class ProductInfo {
	static enum SortMethod {
		BYTITLE, BYPRICE
	};
	
	public void sort(List<Product> emps, final SortMethod method) {
		Collections.sort(emps, (o1,o2)->{
			if(method == SortMethod.BYTITLE) {
				return o1.getTitle().compareTo(o2.getTitle());
			} else {
				return Double.valueOf(o1.getPrice()).compareTo(Double.valueOf(o2.getPrice()));
			}
		});
	}
	public static void main(String[] args) {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("Carpet", 23.0, 2));
		products.add(new Product("Air Condition", 523.0, 1));
		products.add(new Product("Fridge", 423.0, 21));
		products.add(new Product("Funiture", 223.0, 12));
		products.add(new Product("Chair", 123.0, 32));
		ProductInfo info = new ProductInfo();
		info.sort(products, SortMethod.BYPRICE);
		System.out.println(products);

		System.out.println("----------------------------");
		info.sort(products, SortMethod.BYTITLE);
		System.out.println(products);
	}
	
}
