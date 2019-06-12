package lab8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HW2 {
	static enum SortType {
		PRICE, TITLE;
	}

	public static void main(String[] args) {
		/*
		 * a. Sort by implementing a comparator for price attribute and print product
		 * list. b. Sort by implementing a comparator for title attribute and print
		 * product list. c. Implement the sort method so that only one type of
		 * Comparator is used for the task a & b in a Java 7 Way using closure. d. If
		 * the title is same use model as another attribute to sort. Do this by using
		 * lambdas.(Java 8 Way)
		 */

		List<Product> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new Product("a" + i % 5, 100.00 - i % 6, i % 3));
		}

		// a.
//		list.sort((Comparator.comparing(Product::getPrice)));
		sortA(list);

		// b.
//		list.sort((Comparator.comparing(Product::getTitle)));
		sortB(list);

		// c.
		sortC(list, SortType.PRICE);

		// d.
		sortD(list);
	}

	private static void sortD(List<Product> list) {
		list.sort((o1, o2) -> {
			if (o1.getTitle().equals(o2.getTitle())) {
				return o1.getModel() - o2.getModel();
			}
			return o1.getTitle().compareTo(o2.getTitle());
		});
		System.out.println(list);
	}

	private static void sortC(List<Product> list, SortType sortType) {
		list.sort(new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				if (sortType == SortType.PRICE) {
					if (o1.getPrice() > o2.getPrice()) {
						return 1;
					} else if (o1.getPrice() < o2.getPrice()) {
						return -1;
					}
					return 0;
				} else if (sortType == SortType.TITLE) {
					return o1.getTitle().compareTo(o2.getTitle());
				}
				return 0;

			}
		});
		System.out.println(list);
	}

	private static void sortB(List<Product> list) {
		list.sort((o1, o2) -> {
			return o1.getTitle().compareTo(o2.getTitle());
		});
		System.out.println(list);
	}

	private static void sortA(List<Product> list) {
		list.sort((o1, o2) -> {
			if (o1.getPrice() > o2.getPrice()) {
				return 1;
			} else if (o1.getPrice() < o2.getPrice()) {
				return -1;
			}
			return 0;
		});
		System.out.println(list);
	}

	static class Product {
		final String title;
		final double price;
		final int model;

		public String getTitle() {
			return title;
		}

		public double getPrice() {
			return price;
		}

		public int getModel() {
			return model;
		}

		public Product(String title, Double price, int model) {
			this.title = title;
			this.price = price;
			this.model = model;
		}

		@Override
		public String toString() {
			return String.format("\n %s : %s : %s", title, price, model);
		}
	}
}
