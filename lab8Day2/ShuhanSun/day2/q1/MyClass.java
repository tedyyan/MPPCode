package lab8Day2.ShuhanSun.q1;

import java.util.function.Function;

public class MyClass {
    private int x;
    private int y;

    public MyClass(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean myMethod(MyClass cl){
        Function<Object, Boolean> equalsFunc = this::equals;
        return equalsFunc.apply(cl);
    }

    public static void main(String[] args) {
        MyClass c = new MyClass(1,2);
        System.out.println(c.myMethod(c));
        System.out.println(c.myMethod(new MyClass(1,3)));
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
