package chap10;

import java.util.ArrayList;
import java.util.function.Consumer;

public class SampleForEach_01 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		// 拡張for 文
		for (int i : list) {
			System.out.print(i);
		}
		System.out.println();

		// forEach()メソッド 匿名クラスで実装
		list.forEach(new Consumer<Integer>() {
			public void accept(Integer i) {
				System.out.print(i);
			}
		});

		System.out.println();
		// forEach()メソッド ラムダ式で実装
		list.forEach( i -> System.out.print(i));

	}
}




