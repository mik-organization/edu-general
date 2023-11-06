package chap10;

import java.util.function.Supplier;

//関数型インターフェース（Supplier）を実装
class MySupplier implements Supplier<String> {
	@Override
	public String get() {
		return "hello ";
	}
}

public class SampleSupplier_01 {
	public static void main(String[] args) {
		MySupplier ms = new MySupplier();
		System.out.println(ms.get());
	}
}
