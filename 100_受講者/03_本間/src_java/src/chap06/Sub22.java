package chap06;

public class Sub22 extends Super22{
	
	void method(int i){ //オーバーライド
		System.out.println(i + "はint型です。（サブバージョン）");
	}
	void method(String s){ //オーバーロード
		System.out.println(s + "はString型です。");
	}
}
