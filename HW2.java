import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HW2 {

    public static void main(String[] args) {
        /*
        a. Sort by implementing a comparator for price attribute and print product list.
        b. Sort by implementing a comparator for title attribute and print product list.
        c. Implement the sort method so that only one type of Comparator is used for the task a & b in a
        Java 7 Way using closure.
        d. If the title is same use model as another attribute to sort. Do this by using lambdas.(Java 8 Way)
        */

        List<Product> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(new Product("a" + i%5, 100.00 - i%6, i % 3));
        }

        //a.
        list.sort((Comparator.comparing(Product::getPrice)));

        //b.
        list.sort((Comparator.comparing(Product::getTitle)));

        //c.
        list.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                int r = o1.getTitle().compareTo(o2.getTitle());
                int rp = 0;
                if(o1.getPrice() > o2.getPrice()){
                    rp = 1;
                }else if(o1.getPrice() < o2.getPrice()){
                    rp = -1;
                }else{
                    rp = 0;
                }
                return rp == 0 ? r : rp;
            }
        });

        //d.
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
