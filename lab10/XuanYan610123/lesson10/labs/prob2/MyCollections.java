package lesson10.labs.prob2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCollections {
	public static <T extends Comparable<? super T>> T secondSmallest(List<T> list){
		if(list.size()==0||list.size()==1) return null;
		T min = list.get(0);
		T minSecond = list.get(1);
		if(min.compareTo(minSecond)>0) {
			min = list.get(1);
			minSecond = list.get(0);
		}
		for(T i: list) {
			if(i.compareTo(min)>0 && i.compareTo(minSecond)<0) {
				minSecond = i;
			}else if (i.compareTo(min)<0) {
				minSecond = min;
				min = i;
			}
		}
		return minSecond;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> data = new ArrayList<Integer>();
		data.addAll(Arrays.asList(new Integer[] {1,4,5,6,-1}));
		System.out.print(secondSmallest(data));
		
		//result
		//-1
	}
}
