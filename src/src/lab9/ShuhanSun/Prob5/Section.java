package lab9.ShuhanSun.Prob5;

import java.util.Arrays;
import java.util.stream.Stream;



    /*which extracts a substream from the input stream stream consisting of all elements from
     position m to position n, inclusive;
     you must use only Stream operations to do this. You can assume 0 <= m <= n.*/


public class Section {
    public static Stream<String> streamSection(Stream<String> stream, int m, int n) {
// Implement the code
        return stream.skip(m).limit(n-m+1);
    }

    public static void main(String[] args) {
// Make three calls for the streamSection() method with different inputs
// use nextStream() method to supply the Stream input as a first argument in streamSection() method
        streamSection(nextStream(), 2, 5).forEach(System.out::println);
//        streamSection(nextStream(), 1, 8).forEach(System.out::println);
//        streamSection(nextStream(), 0, 2).forEach(System.out::println);
    }

    //support method for the main method -- for testing
    private static Stream<String> nextStream() {
        return Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii").stream();
    }
}

