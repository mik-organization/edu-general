package chap06;

// （public）インターフェース
interface Inter42 {

	// フィールド
	int NUM = 456;

	// メソッド
	void mtd(int i);
	
	// defaultメソッド
	default void hello() {
		System.out.println("Hello New Interface");
	}

	// staticメソッド
	static String message(String name) {
		return name + "さん、こんにちは。";
	}
}
//-------------------------------------
// インターフェースの実装クラス
class InterImp42 implements Inter42 {
	@Override
	public void mtd(int i) { // 親のmtdメソッドの実装メソッド
		System.out.println(i);
	}
}
//-------------------------------------
// アプリケーションクラス
public class Sample42 {

	public static void main(String[] args) {

		Inter42 in = new InterImp42();
		in.mtd(123);
		System.out.println(in.NUM);
		in.hello();
		System.out.println(Inter42.message("山田"));
		
	}
}
