abstract class Employee {
    private String empId;
    private int month;
    private int year;

    public Employee(String empId) {
        this.empId = empId;
    }

    public void print(int month, int year) {
        System.out.println("Month: " + month + " Year: " + year);
        System.out.println("Employee Id: " + getEmpId());
        this.month = month;
        this.year = year;
        Paycheck paycheck = calcCompensation();
        System.out.println(paycheck);
        System.out.println(" ");
    }

    public Paycheck calcCompensation() {
        return new Paycheck(calcGrossPay());
    }

    abstract double calcGrossPay();

    public String getEmpId() {
        return empId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
