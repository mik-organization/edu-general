package chap09;

import java.util.HashSet;

public class Sample05 {
	public static void main(String args[]) {

		MyNumber1 n1 = new MyNumber1(1);
		MyNumber1 n2 = new MyNumber1(2);
		MyNumber1 n3 = new MyNumber1(3);

		HashSet hs = new HashSet();
		hs.add(n1);
		hs.add(n2);
		hs.add(n3);
		
		n1=new MyNumber1(1);
		hs.add(n1);

		for (Object obj : hs) {
			System.out.println(((MyNumber1) obj).num);
		}
		
	}
}
