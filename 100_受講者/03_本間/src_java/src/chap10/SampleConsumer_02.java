package chap10;

import java.util.function.Consumer;

public class SampleConsumer_02 {
	public static void main(String[] args) {
		
		//関数型インターフェース（Consumer）を匿名クラスで実装
		Consumer<String> com = new Consumer<String>() {
			@Override
			public void accept(String str) {
				System.out.println("hello " + str);
			}
		};
		com.accept("ken");
	}
}
