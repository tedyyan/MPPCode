package lab8.day1.prob2.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lab8.day1.prob2.Product;
public class ProductInfo {
	
	public void sort(List<Product> emps) {
		Collections.sort(emps, (o1,o2)->{
			if(o1.getTitle().equals(o2.getTitle())) {
				return Integer.valueOf(o1.getModel()).compareTo(Integer.valueOf(o2.getModel()));
			} else {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});
	}
	public static void main(String[] args) {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("Carpet", 23.0, 2));
		products.add(new Product("Air Condition", 523.0, 1));
		products.add(new Product("Air Condition", 423.0, 21));
		products.add(new Product("Air Condition", 223.0, 12));
		products.add(new Product("Chair", 123.0, 32));
		ProductInfo info = new ProductInfo();
		info.sort(products);
		System.out.println(products);

	}
	
}
