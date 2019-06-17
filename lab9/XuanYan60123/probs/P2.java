package probs;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class P2 {
	public static void main(String[] args) {
		Stream<Integer> myIntStream = Stream.of(1,2,3);
		IntSummaryStatistics summaryStats = myIntStream.collect(Collectors.summarizingInt(Integer::intValue));
		System.out.println(summaryStats.getMax());
		System.out.println(summaryStats.getMin());
	}
}
