package lab8Day2.ShuhanSun.q2;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //i.
        Supplier<Double> randomSup = Math::random;
        System.out.println(randomSup.get());

        //ii.
        Supplier<Double> randomSupLa =  ()-> Math.random();
        System.out.println(randomSupLa.get());

        //iii.
        MyRondom myRondom = new Main().new MyRondom();
        System.out.println(myRondom.get());
    }

    class MyRondom implements Supplier{

        @Override
        public Object get() {
            return Math.random();
        }
    }


}
