package lab9.ShuhanSun;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Prob2 {
    public static void main(String[] args) {



        //2. You have a Stream of Integers called myIntStream and you need to output both the
        //maximum and minimum values. Write compact code that efficiently accomplishes this.
        Optional<Integer> max = Stream.of(5, 0, 2, 45, 7).max(Comparator.comparingInt(a -> a));
        Optional<Integer> min = Stream.of(5, 0, 2, 45, 7).min(Comparator.comparingInt(a -> a));
        System.out.println("max:" + max.get() + " min:" + min.get());
    }
}
