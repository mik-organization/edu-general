package chap09;

import java.util.HashMap;
import java.util.Set;

public class Sample07 {
	public static void main(String args[]) {

		HashMap hm = new HashMap();

		hm.put(" orange", new Myclass2("みかん", "愛媛"));
		hm.put(" grape", new Myclass2("ぶどう", "山梨"));
		hm.put(" apple", new Myclass2("りんご", "青森"));
		hm.put(" peach", new Myclass2("桃", "岡山"));

		Set keys = hm.keySet();

		for (Object obj : keys) {
			System.out.print(obj + ",");
		}

		System.out.println("\n");

		for (Object o : keys) {
			Myclass2 m2 = (Myclass2) hm.get(o);
			System.out.println(m2.fruits + "：" + m2.locality);
		}

	}
}
