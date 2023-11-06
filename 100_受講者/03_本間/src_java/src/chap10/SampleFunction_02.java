package chap10;

import java.util.function.Function;

public class SampleFunction_02 {
	public static void main(String[] args) {

		Function<String, String> fun = new Function<String, String>() {
			@Override
			public String apply(String str) {
				return "hello " + str;
			}
		};

		System.out.println(fun.apply("ken"));
	}
}
