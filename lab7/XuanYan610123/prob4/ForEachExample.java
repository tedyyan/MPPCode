package prob4;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;


public class ForEachExample {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//print each element of the list in upper case format
		Upper upper = new ForEachExample(). new Upper();
		list.forEach(upper);
		
		
	}
	
	//implement a Consumer
	class Upper implements Consumer<String>{

		@Override
		public void accept(String t) {
			System.out.print(t.toUpperCase() + " ");
			
		}
		
	}
	
}