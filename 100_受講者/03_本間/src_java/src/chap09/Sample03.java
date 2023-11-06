package chap09;

import java.util.ArrayList;

public class Sample03 {
	public static void main(String args[]) {
		
		// コレクションの生成、要素の追加
		ArrayList al = new ArrayList();
		al.add("おはよう");
		al.add("こんにちは");
		al.add("こんばんは");
		
		System.out.println("al.size()："+ al.size());
		
		// 要素の取り出し
		for (int i = 0; i < al.size(); i++) {
			System.out.println("al.size("+i+")："+ al.get(i));
		}
		
		System.out.println();
		
		al.remove(1);
		System.out.println("al.size()："+ al.size());
		for (int i = 0; i < al.size(); i++) {
			System.out.println("al.size("+i+")："+ al.get(i));
		}
	}
}
