package chap10;

//関数型インターフェース（Predicate）を匿名クラスで実装
import java.util.function.Predicate;

public class SamplePredicate_02 {
	public static void main(String[] args) {
		
		Predicate<String> pr = new Predicate<String>() {
			@Override
			public boolean test(String str) {
				return str.equals("ken");
			}
		};
		if (pr.test("ken")) {
			System.out.println("ken です。");
		} else {
			System.out.println("ken ではありません。");
		}
	}
}
