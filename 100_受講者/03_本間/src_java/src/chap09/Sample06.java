package chap09;

import java.util.HashMap;

public class Sample06 {
	public static void main(String args[]) {

		MyNumber1 n1 = new MyNumber1(1);
		MyNumber1 n2 = new MyNumber1(2);
		MyNumber1 n3 = new MyNumber1(3);
		MyNumber1 n4 = new MyNumber1(4);

		HashMap hm = new HashMap();
		hm.put(1, n1);
		hm.put(2, n2);
		hm.put(3, n3);
		hm.put(1, n4);

		for (int i=1;i<=hm.size();i++) {
			System.out.println(((MyNumber1)(hm.get(i))). num);
		}

	}
}
