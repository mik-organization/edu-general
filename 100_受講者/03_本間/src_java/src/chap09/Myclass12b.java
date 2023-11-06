package chap09;

public class Myclass12b {

	<t1,t2> void swap(t1 x, t2 y) {
		if (x==y) {
			System.out.println("x：" + x + "　 y：" + y);
			System.out.println("同じ値です。\n");
		} else {
			System.out.println("x：" + x + "　y：" + y);
			System.out.println("違う値です。\n");
		}
	}
}
