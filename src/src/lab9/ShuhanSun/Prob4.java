package lab9.ShuhanSun;

import java.util.stream.IntStream;

public class Prob4 {
    /*4. Implement a method
public static void printSquares(int num)
which creates an IntStream using the iterate method.
 The method prints to the console the first num squares.
 For instance, if num = 4, then your method would output 1, 4, 9, 16.
 Note: You will need to come up with a function to be used in the second argument of iterate.

*/

    public static void main(String[] args) {

        printSquares(4);
    }

    public static void printSquares(int num) {
        IntStream.iterate(1, value -> ++value).map(a -> a * a).limit(4).forEach(System.out::println);
    }
}
