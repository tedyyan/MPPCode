final public class Paycheck {
    private double grossPay;
    final double fica = 0.23;
    final double state = 0.05;
    final double local = 0.01;
    final double medicare = 0.03;
    final double socialSecurity = 0.075;

    public Paycheck(double grossPay) {
        this.grossPay = grossPay;
    }

    public void print() {
        System.out.println(toString());
    }

    public double getNetPay() {
        return grossPay - grossPay * (fica + state + local + medicare + socialSecurity);
    }

    @Override
    public String toString() {
        return "PayStub: \n" +
                "grossPay=" + grossPay +
                "\nfica=" + fica +
                "\nstate=" + state +
                "\nlocal=" + local +
                "\nmedicare=" + medicare +
                "\nsocialSecurity=" + socialSecurity
                +"\nnetPay=" + getNetPay();
    }

    ;


}
