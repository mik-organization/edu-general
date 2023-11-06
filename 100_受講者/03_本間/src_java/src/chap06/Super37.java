package chap06;

public abstract class Super37 {

	// 抽象メソッド
	abstract void ab();
	abstract void ab2(); // 親クラスの中で、抽象メソッドをもう一つ追加する

	//具象メソッド
	void me() {
		System.out.println("Super");
	}
}
