package chap06;

public interface InterSuper43A {
	String NAME = "インターA"; // フィールド

	void methodA(); // 抽象メソッド①

	default void method() { // defaultメソッド
		System.out.println("InterSuper43A");
	}
}
