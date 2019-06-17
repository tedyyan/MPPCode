package prob7b;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee("Joe", "Davis", 120000),
				          new Employee("John", "Sims", 110000),
				          new Employee("Joe", "Stevens", 200000),
		                  new Employee("Andrew", "Reardon", 80000),
		                  new Employee("Joe", "Cummings", 760000),
		                  new Employee("Steven", "Walters", 135000),
		                  new Employee("Thomas", "Blake", 111000),
		                  new Employee("Alice", "Richards", 101000),
		                  new Employee("Donald", "Trump", 100000));
		Integer salaryInteger = 1000;
		Character startC = 'M';
		Character endC = 'Z';
		final BiFunction<List<Employee>,Integer,String> lamdalibFunction = 
				(list2,s)-> 
					 list2.stream().filter(x -> x.getSalary() > s).filter(x -> x.getLastName().charAt(0) > 'M')
						.filter(x -> x.getLastName().charAt(0) < ('Z' + 1)).map(x -> x.getLastName() + " " + x.getFirstName())
						.sorted().collect(Collectors.joining(","));
		System.out.println(lamdalibFunction.apply(list,salaryInteger));
	}

}
