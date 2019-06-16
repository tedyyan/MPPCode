package lab9.ShuhanSun;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prob6 {

    public static void main(String[] args) {

        List<Set<String>> list = new ArrayList();
        list.add(new HashSet<>(Arrays.asList("A", "B")));
        list.add(new HashSet<>(Arrays.asList("D")));
        list.add(new HashSet<>(Arrays.asList("1", "3", "5")));
        System.out.println(new Prob6().union(list));
    }
    /*by creating a stream pipeline that transforms a list of sets (of type String)
     into the union of those sets. Make use of the reduce method for streams.
Example: The union method should transform the list [{“A”, “B”}, {“D”}, {“1”, “3”, “5”}]
 to the set {“A”, “B”, “D”, “1”, “3”, “5”}.*/
    public Set<String> union(List<Set<String>> sets){
        return sets.stream().flatMap(Collection::stream).collect(Collectors.toSet());
    }
}
