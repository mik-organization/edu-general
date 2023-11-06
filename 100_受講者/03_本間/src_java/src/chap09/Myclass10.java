package chap09;

public class Myclass10 {

	public static <T> void myMethod1(T var) {

		System.out.println(var);
	}
	
	public static <T> void myMethod2(T var1, T var2) {

		System.out.println(var1 + "," + var2);
	}
	
	public static <T1, T2> void myMethod3(T1 var1, T2 var2) {

		System.out.println(var1 + "," + var2);
	}

}
