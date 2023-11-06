package chap10;

public class Outer1 {

	int i = 10;
	static int s = 20;

	public class A {
		//static int ii=2;
		int j = 11;
		int k = i;

		void meth0() {
			System.out.println("i=" + i);
			System.out.println("s=" + s);
			System.out.println("j=" + j);
			System.out.println("k=" + k);
		}
	}
	
	static class B {
		static int bi = 12;
		//int bi2=i;

		void meth1() {
			System.out.println("s=" + s);
		}
	}
}
