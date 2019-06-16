package lab9.ShuhanSun.prob7b;


import java.util.List;
import java.util.stream.Stream;

public class LambdaLibrary {
    public static final TriFunction<List<Employee>, Integer, Character, Stream<String>> lambad =
            (List<Employee> list, Integer salaryMin, Character lastNameChar) ->
                    list.stream().filter(employee -> employee.getSalary() > salaryMin)
                            .filter(employee -> employee.getLastName().charAt(0) >= lastNameChar)
                            .filter(employee -> employee.getLastName().charAt(0) <= 'Z')
                            .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                            .sorted();
}
