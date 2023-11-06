package chap10;

import java.util.function.Function;

public class SampleFunction_04 {
	public static void main(String[] args) {

		Function<String, String> fun = str -> "hello " + str;

		System.out.println(fun.apply("ken"));
	}
}
