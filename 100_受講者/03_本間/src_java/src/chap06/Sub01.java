package chap06;

public class Sub01 extends Super01 { // Super01クラスを継承する

	/* 	継承することで、
		下のように親クラスのSuper01の内容が書いてあるのと同じように扱える
	 
	 // フィールド
	int superi = 0;
	
	// メソッド
	void superwrite(String s) {
		System.out.println("Super01:"+s);
	}
	 
	 */

	// フィールド
	int subi = 1;

	// メソッド
	void subwrite(String s) {
		System.out.println("Sub01:" + s);
	}
}
