package probs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class P3 {
	public int countWords(List<String> words, char c, char d, int len) {
		final Function<List<String>, Long> listStartsWith 
	    = (list) -> list.stream()
	                            .filter(word -> word.length() == len)
	                            .filter(name -> name.contains( Character.valueOf(c).toString()))
	                            .filter(name -> !name.contains(Character.valueOf(d).toString()))
	                            .count();    
	    return listStartsWith.apply(words).intValue();
		
	}
	public static void main(String[] args) {
		P3 p3 = new P3();
		System.out.print(p3.countWords(Arrays.asList(new String[]{"ac","cc","da"}), 'c', 'd', 2));
	}
}
