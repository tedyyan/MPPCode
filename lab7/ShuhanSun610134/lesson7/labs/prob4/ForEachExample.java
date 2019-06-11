package lesson7.labs.prob4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class ForEachExample {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		List<String> rlist = new ArrayList<String>();
		Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String t) {
				rlist.add(t.toUpperCase());
			}
		};
		list.stream().forEach(consumer);
		
//		List<String> rrlist = list.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(rlist);

	}
	
	//implement a Consumer
	
	
}