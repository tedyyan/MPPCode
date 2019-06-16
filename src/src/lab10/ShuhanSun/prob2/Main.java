package lab10.ShuhanSun.prob2;

import java.util.Arrays;
import java.util.List;

public class Main {

    /*
     * Create a generic programming solution to the problem of finding the second
     * smallest element in a list.
     * In other words, devise a public static method secondSmallest
     * so that it can handle the biggest possible range of types.
     * */
    public static void main(String[] args) {
        int secondSmallest = secondSmallest(Arrays.asList(20, 50, 100, 70, 34, 80));
        System.out.println(secondSmallest);
    }

    public static <T extends Comparable> T secondSmallest(List<T> list){
        list.sort((a,b)->a.compareTo(b));
        if(list.size() < 2){
            return null;
        }
        return list.get(1);
    }
}
