package chap06;

public class Super06A {
	final void writeln() {
		System.out.println("Super");
	}
}

class Sub06A extends Super06A {
	/* スーパークラスで final メソッドはオーバーライドできないため、エラー
	public void writeln() {
		System.out.println("Sub");
	}
	*/
}
