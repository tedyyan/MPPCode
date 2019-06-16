package lab9.ShuhanSun.prob7a;

import java.util.*;

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
		
		//your stream pipeline here
		/*In the final line of the main method, write a stream pipeline (using filters and maps)
		 which prints, in sorted order (comma-separated, on a single line),
		 the full names (first name + “ “ + last name) of all Employees in the list
		  whose salary is greater than $100,000
		  and whose last name begins with any of the letters in the alphabet past the letter ‘M’
		  (so, any letters in the range ‘N’--‘Z’).
		  Filter the lastname which is after M in the alphabets,
		  that is filtered names should be in the range of N—Z.
	For the main method provided in your lab folder, expected output is:
              Alice Richards, Joe Stevens, John Sims, Steven Walters*/

		list.stream().filter(employee -> employee.getSalary() > 100000)
				.filter(employee -> employee.getLastName().charAt(0) >= 'N')
				.filter(employee -> employee.getLastName().charAt(0) <= 'Z')
				.map(employee -> employee.getFirstName() + " " + employee.getLastName())
				.sorted()
				.forEach(System.out::println);


	}

}
