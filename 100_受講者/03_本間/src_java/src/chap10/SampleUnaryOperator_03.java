package chap10;

//関数型インターフェース（Supplier）を匿名クラスで実装
import java.util.function.UnaryOperator;

public class SampleUnaryOperator_03 {
	public static void main(String[] args) {
		UnaryOperator<String> uo = (String str)-> {
				return "hello " + str;
		};
		System.out.println(uo.apply("ken"));
	}
}
