package chap06;

public class Sub02 extends Super02 { // Super02クラスを継承

	// メソッド
	void write() {
		System.out.println("Subです。");
	}
	
	// 方法その2　クラス型の super. キーワードで親クラスのメソッドを呼び出す
	void writeSuper() {
		super.write();
	}
}
