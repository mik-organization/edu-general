package chap06;

public class Sub04 extends Super04 { // Super04クラスを継承

	// コンストラクタ
	public Sub04() {
		System.out.println("Subコンストラクタ。");
	}

	public Sub04(String s) {
		super(s);
		System.out.println(s);
	}
}
