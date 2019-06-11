package lab8.prob2.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lab8.prob2.Product;
import lab8.prob2.a.PriceComparator;


public class ProductInfo {
	static enum SortMethod {
		BYTITLE, BYPRICE
	};
	
	public void sort(List<Product> emps, final SortMethod method) {
		class ProductComparator implements Comparator<Product> {
			@Override
			public int compare(Product o1, Product o2) {
				if(method == SortMethod.BYTITLE) {
					return o1.getTitle().compareTo(o2.getTitle());
				} else {
					return Double.valueOf(o1.getPrice()).compareTo(Double.valueOf(o2.getPrice()));
				}
			}
		}
		Collections.sort(emps, new ProductComparator());
	}
	
	public static void main(String[] args) {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("Carpet", 23.0, 2));
		products.add(new Product("Air Condition", 523.0, 1));
		products.add(new Product("Fridge", 423.0, 21));
		products.add(new Product("Funiture", 223.0, 12));
		products.add(new Product("Chair", 123.0, 32));
		ProductInfo pInfo = new ProductInfo();
		pInfo.sort(products, SortMethod.BYPRICE);		
		System.out.println(products);
		System.out.println("----------------");
		pInfo.sort(products, SortMethod.BYTITLE);		
		System.out.println(products);
	}
}
