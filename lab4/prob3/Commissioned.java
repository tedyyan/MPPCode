


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commissioned extends Employee {
    private double baseSalary;
    private double commission;
    private List<Order> orders;

    public Commissioned(String empId, double baseSalary, double commission, List<Order> orders) {
        super(empId);
        this.baseSalary = baseSalary;
        this.commission = commission;
        this.orders = orders;
    }

    public void addOrder(int orderNo, LocalDate orderDate, int orderAmount) {
        orders.add(new Order(orderNo, orderDate, orderAmount));
    }

    @Override
    double calcGrossPay() {

        double commissions = 0;
        for (Order order : orders) {
            if (this.getMonth() == 1 && order.getOrderDate().getYear() + 1 == this.getYear()
                    && order.getOrderDate().getMonthValue() == 12) {
                commissions += order.getOrderAmount();
            } else if (order.getOrderDate().getYear() == this.getYear() &&
                    (order.getOrderDate().getMonthValue() + 1) == this.getMonth()) {
                commissions += order.getOrderAmount();
            }


        }

        return baseSalary + commission * commissions;
    }
}
