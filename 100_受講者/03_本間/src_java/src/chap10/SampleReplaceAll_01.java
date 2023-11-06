package chap10;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

/*
 * コレクションAPI
 * replaceAll
 * UnaryOperator 関数インターフェースを匿名クラスで実装
 */
public class SampleReplaceAll_01 {
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
		 * UnaryOperator インターフェースのインスタンスを 匿名クラスで作成する。
		 */
		UnaryOperator<String> uo = new UnaryOperator<String>() {
			@Override
			public String apply(String str) {
				return str.toUpperCase();
			}
		};
		/*
		 * replaceAll()メソッドの引数にUnaryOperator インターフェース
		 * のインスタンスを指定し全ての要素に対し処理を行い内容を 変更する。
		 */
		names.replaceAll(uo);
		for (String str : names) {
			System.out.println(str);
		}
	}
}