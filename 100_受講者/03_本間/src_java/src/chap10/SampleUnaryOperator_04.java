package chap10;

//関数型インターフェース（Supplier）を匿名クラスで実装
import java.util.function.UnaryOperator;

public class SampleUnaryOperator_04 {
	public static void main(String[] args) {
		
		UnaryOperator<String> uo = str -> "hello " + str;
		
		System.out.println(uo.apply("ken"));
	}
}
