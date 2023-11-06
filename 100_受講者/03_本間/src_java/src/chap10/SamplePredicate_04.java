package chap10;

//関数型インターフェース（Predicate）を匿名クラスで実装
import java.util.function.Predicate;

public class SamplePredicate_04 {
	public static void main(String[] args) {

		Predicate<String> pr = str -> str.equals("ken");

		if (pr.test("ken")) {
			System.out.println("ken です。");
		} else {
			System.out.println("ken ではありません。");
		}
	}
}
