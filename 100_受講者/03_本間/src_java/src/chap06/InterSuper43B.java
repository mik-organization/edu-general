package chap06;

public interface InterSuper43B {
	String NAME = "インターB"; // フィールド

	void methodB(); // 抽象メソッド②

	default void method() { // defaultメソッド
		System.out.println("InterSuper43B");
	}
}
