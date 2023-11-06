package chap09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Sample08_01 {

	public static void main(String[] args) {

		// 便利な使い方。
		// その①　型変換しなくても直接取り出せる
		ArrayList<String> al = new ArrayList<String>();
		al.add("おはよう");
		al.add("こんにちは");
		al.add("こんばんは");

		for (String s : al)
			System.out.println(s);

		//その②　HashMap
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "おはよう");
		hm.put(2, "こんにちは");
		hm.put(3, "こんばんは");
		
		Set<Integer> keys=hm.keySet();
		for(Integer k: keys) {
			System.out.println("key："+ k);
		}
		
		for (int i = 1; i <= 3; i++) {
			String s = hm.get(i);
			System.out.println(s);
		}

	}

}
