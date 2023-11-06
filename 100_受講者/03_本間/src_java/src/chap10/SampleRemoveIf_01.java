package chap10;

import java.util.ArrayList;
import java.util.function.Predicate;

/*
 * コレクションAPI
 * removeIf
 * Predicate 関数インターフェースを匿名クラスで実装
 */
public class SampleRemoveIf_01 {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("Tanaka");
		names.add("Ito");
		names.add("Sato");
		for (String str : names) {
			System.out.println(str);
		}
		System.out.println();
		// Predicate インターフェースで条件をしたインスタンスを作成
		Predicate<String> pr = new Predicate<String>() {
			public boolean test(String str) {
				return str.equals("Ito");
			}
		};
		// removeIf で条件に合った（true）要素を削除する。
		names.removeIf(pr);
		for (String str : names) {
			System.out.println(str);
		}
	}
}