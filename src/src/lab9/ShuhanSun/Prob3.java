package lab9.ShuhanSun;

import java.util.*;

public class Prob3 {

    public static void main(String[] args) {


    /*
    3. Implement a given method requirement using Lambdas and streams in a Java 8 way.
    public int countWords(List<String> words, char c, char d, int len)
    which counts the number of words in the input list words that have length equal to len,
     that contain the character c, and that do not contain the character d.
	 * */
        List<String> list = Arrays.asList("abc", "aaa", "ccc", "abd", "f", "fdsa");
        System.out.println(new Prob3().countWords(list, 'c', 'd', 3));


    }

    public int countWords(List<String> words, char c, char d, int len) {
        return (int) words.stream().filter((s) -> s.length() == len && s.contains("" + c) && !s.contains("" + d))
                .count();
    }

}
