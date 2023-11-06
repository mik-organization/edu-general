package chap09;

public class Myclass12a<T> {

	void swap(T x, T y) {
		if (x==y) {
			System.out.println("x：" + x + "　 y：" + y);
			System.out.println("同じ値です。\n");
		} else {
			System.out.println("x：" + x + "　y：" + y);
			System.out.println("違う値です。\n");
		}
	}
}
