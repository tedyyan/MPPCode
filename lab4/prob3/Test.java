

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        List<Order> list = new ArrayList<>();
        list.add(new Order(100, LocalDate.of(2019, 1, 1), 200));
        list.add(new Order(101, LocalDate.of(2019, 1, 10), 201));
        Commissioned cm = new Commissioned("123", 500, 0.8, list);
        Employee[] emp = {new Salaried("124", 1000), new Hourly("125", 123, 40), cm};
        for (Employee e : emp) {
            e.print(2, 2019);

        }
    }
}
