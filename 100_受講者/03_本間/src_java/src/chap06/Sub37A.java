package chap06;

public class Sub37A extends Super37 {

	@Override
	void ab() { // 親の抽象メソッドをオーバーライドして実装する
		System.out.println("Sub");
	}
	
	@Override
	void ab2() {}
	// 継承した親クラスに複数の抽象メソッドがある場合は全てORしなければならない

}

class Sub37B extends Super37 {

	@Override
	void ab() { // 上の子Aとは処理を変えて実装する
		
		// ブロックの中身が無くても実装したことになる。
		// コンパイルエラーなども起きない。
	}
	
	@Override
	void ab2() {} // 上のA同様にORしてコンパイルエラーを消しておく
}

