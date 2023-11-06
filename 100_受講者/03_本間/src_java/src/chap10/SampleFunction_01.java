package chap10;

//関数型インターフェース（Function）を実装
import java.util.function.Function;

class MyFunction implements Function<String, String> {
	/*
	public R apply(T str);
	*/
	@Override
	public String apply(String str) {
		return "hello " + str;
	}
}

public class SampleFunction_01 {
	public static void main(String[] args) {
		MyFunction mf = new MyFunction();
		String str = mf.apply("ken");
		System.out.println(str);
	}
}
