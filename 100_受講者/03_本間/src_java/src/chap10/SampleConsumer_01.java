package chap10;

//関数型インターフェース（Consumer）を実装
import java.util.function.Consumer;

class MyConsumer implements Consumer<String> {
	@Override
	public void accept(String str) {
		System.out.println("hello " + str);
	}
}

public class SampleConsumer_01 {
	public static void main(String[] args) {
		MyConsumer mC = new MyConsumer();
		mC.accept("Ken");
	}
}
