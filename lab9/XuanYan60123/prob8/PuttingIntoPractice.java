package prob8;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.omg.CORBA.PUBLIC_MEMBER;

public class PuttingIntoPractice {
	public static void main(String... args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// Query 1: Find all transactions from year 2011 and sort them by value (small
		// to high).

		System.out.println("-------------------------------");
		transactions.stream().filter(x -> x.getYear() > 2011).sorted(Comparator.comparing(Transaction::getValue))
				.forEach(System.out::println);

		// Query 2: What are all the unique cities where the traders work?
		System.out.println("-------------------------------");
		transactions.stream().map(x -> x.getTrader().getCity()).distinct().forEach(System.out::println);

		// Query 3: Find all traders from Cambridge and sort them by name.
		System.out.println("-------------------------------");
		transactions.stream().filter(x -> x.getTrader().getCity() == "Cambridge")
				.sorted((x, y) -> x.getTrader().getName().compareTo(y.getTrader().getName())).map(x -> x.getTrader())
				.distinct().forEach(System.out::println);

		// Query 4: Return a string of all traders names sorted alphabetically.
		System.out.println("-------------------------------");
		System.out.println(transactions.stream().map(x -> x.getTrader().getName()).distinct().sorted()
				.collect(Collectors.joining(" ")));

		// Query 5: Are there any trader based in Milan?
		System.out.println("-------------------------------");
		System.out.println(
				transactions.stream().map(x -> x.getTrader()).filter(x -> x.getCity().equals("Milan")).count() > 0);

		// Query 6: Update all transactions so that the traders from Milan are set to
		// Cambridge.
		System.out.println("-------------------------------");
		transactions = transactions.stream().map(x -> {
			if (x.getTrader().getCity().equals("Milan"))
				x.getTrader().setCity("Cambridge");
			return x;
		}).collect(Collectors.toList());
		transactions.stream().forEach(System.out::println);
		
		// Query 7: What's the highest value in all the transactions?
		System.out.println("-------------------------------");
		System.out.println(transactions.stream().collect(Collectors.summarizingInt(x -> x.getValue())).getMax());

//Result:
//		-------------------------------
//		{Trader:Mario in Milan, year: 2012, value:700}
//		{Trader:Mario in Milan, year: 2012, value:710}
//		{Trader:Alan in Cambridge, year: 2012, value:950}
//		{Trader:Raoul in Cambridge, year: 2012, value:1000}
//		-------------------------------
//		Cambridge
//		Milan
//		-------------------------------
//		Trader:Alan in Cambridge
//		Trader:Brian in Cambridge
//		Trader:Raoul in Cambridge
//		-------------------------------
//		Alan Brian Mario Raoul
//		-------------------------------
//		true
//		-------------------------------
//		{Trader:Brian in Cambridge, year: 2011, value:300}
//		{Trader:Raoul in Cambridge, year: 2012, value:1000}
//		{Trader:Raoul in Cambridge, year: 2011, value:400}
//		{Trader:Mario in Cambridge, year: 2012, value:710}
//		{Trader:Mario in Cambridge, year: 2012, value:700}
//		{Trader:Alan in Cambridge, year: 2012, value:950}
//		-------------------------------
//		1000
	}
}
