package chap10;

//関数型インターフェース（Predicate）を実装
import java.util.function.Predicate;

class MyPredicate implements Predicate<String> {
	@Override
	public boolean test(String str) {
		return str.equals("ken");
	}
}

public class SamplePredicate_01 {
	public static void main(String[] args) {
		MyPredicate mp = new MyPredicate();
		if (mp.test("ken")) {
			System.out.println("ken です。");
		} else {
			System.out.println("ken ではありません。");
		}
	}
}