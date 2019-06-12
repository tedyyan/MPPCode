package lab8.day2.prob1;

import java.util.function.Predicate;

public class MyClass {
	int x;
	int y;
	public MyClass(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	@Override
	public int hashCode() {
		
		return Integer.valueOf(x).hashCode()<<16 + Integer.valueOf(y).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(!(obj instanceof MyClass)) {
			return false;
		}
		MyClass tmpClass = (MyClass) obj;
		if((tmpClass.x==this.x) &&(tmpClass.y==this.y)) {
			return true;
		}else {
			return false;
		}
	}
	
	boolean myMethod(MyClass cl) {
		Predicate<MyClass> lamda = this::equals;
		return lamda.test(cl);
		 
	}
	
	public static void main(String[] args) {
		MyClass a1 = new MyClass(1,2);
		System.out.println(a1.myMethod(new MyClass(1, 2)));
		System.out.println(a1.myMethod(new MyClass(11, 2)));
	}
	
}
