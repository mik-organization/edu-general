package chap10;

public class Sub04 extends Super04 { //Super17クラスを継承
	@Override
	public void meth(){ //meth()をオーバーライド
		System.out.println("str = " + str); //スーパークラスのstrの値を表示
	}
}
