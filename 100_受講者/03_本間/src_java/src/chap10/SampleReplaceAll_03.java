package chap10;

import java.util.ArrayList;

/*
 * コレクションAPI
 * replaceAll
 * UnaryOperator 関数インターフェースを匿名クラスで実装
 */
public class SampleReplaceAll_03 {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("Tanaka");
		names.add("Ito");
		names.add("Sato");
		for (String str : names) {
			System.out.println(str);
		}
		System.out.println();

		/*
		 * replaceAll()メソッドの引数にUnaryOperator インターフェース
		 * のインスタンスを指定し全ての要素に対し処理を行い内容を 変更する。
		 */
		names.replaceAll(str -> str.toUpperCase());

		for (String str : names) {
			System.out.println(str);
		}
	}
}