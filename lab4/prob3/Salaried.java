public class Salaried extends Employee {
    private double salary;

    public Salaried(String empId, double salary) {
        super(empId);
        this.salary = salary;
    }



    @Override
    double calcGrossPay() {
        return salary;
    }
}
