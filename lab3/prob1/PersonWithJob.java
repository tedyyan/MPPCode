package lesson3.labs.prob1;

public class PersonWithJob {
    private Person person;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public Person getPerson() {
        return person;
    }

    PersonWithJob(Person person, double s) {
        this.person = person;
        salary = s;
    }

    @Override
    public boolean equals(Object aPerson) {
        if (aPerson == null) return false;
        if (!(aPerson instanceof PersonWithJob)) {
            return false;
        }


        PersonWithJob p = (PersonWithJob) aPerson;
        boolean isEqual = this.person.getName().equals(p.person.getName()) &&
                this.getSalary() == p.getSalary();
        return isEqual;
    }

    public static void main(String[] args) {
        Person p2 = new Person("Joe");
        PersonWithJob p1 = new PersonWithJob(p2, 30000);

        //As PersonsWithJobs, p1 should be equal to p2
        System.out.println("p1.equals(p2)? " + p1.equals(p2));
        System.out.println("p2.equals(p1)? " + p2.equals(p1));
    }


}
