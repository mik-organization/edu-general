package chap10;

//関数型インターフェース（Supplier）を実装
import java.util.function.UnaryOperator;

class MyUnaryOperator implements UnaryOperator<String> {
	@Override
	public String apply(String str) {
		return "hello " + str;
	}
}

public class SampleUnaryOperator_01 {
	public static void main(String[] args) {
		MyUnaryOperator mu = new MyUnaryOperator();
		String str = mu.apply("ken");
		System.out.println(str);
	}
}