package probs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P6 {
	public static Set<String> union(List<Set<String>> sets){
		
		
		return sets.stream().reduce((a,b)->{a.addAll(b);return a;}).get();
		
	}
	
	public static Set<String> union2(List<Set<String>> sets){
		//Set<String> kSet;
		//kSet.stream
		
		return sets.stream().flatMap(Collection::stream).collect(Collectors.toSet());
		
	}
	
	public static void main(String[] args) {
		List<Set<String>> listA = new ArrayList<>();
		Set<String>  st1 = new TreeSet<String>();
		st1.add("aa");
		st1.add("bb");
		Set<String>  st2 = new TreeSet<String>();
		st1.add("aa");
		st1.add("cc");
		listA.add(st1);
		listA.add(st2);
		System.out.print(P6.union(listA ));
		System.out.print(P6.union2(listA ));
	}
}
