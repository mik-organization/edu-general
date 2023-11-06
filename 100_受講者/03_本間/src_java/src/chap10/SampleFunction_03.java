package chap10;

import java.util.function.Function;

public class SampleFunction_03 {
	public static void main(String[] args) {

		Function<String, String> fun = (String str) -> {
			return "hello " + str;

		};

		System.out.println(fun.apply("ken"));
	}
}
