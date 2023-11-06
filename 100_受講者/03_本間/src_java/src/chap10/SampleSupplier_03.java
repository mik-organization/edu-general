package chap10;

import java.util.function.Supplier;

//関数型インターフェース（Supplier）を匿名クラスで実装
public class SampleSupplier_03 {
	public static void main(String[] args) {

		Supplier<String> su = () -> {
			return "hello ";
		};
		System.out.println(su.get());
	}
}
