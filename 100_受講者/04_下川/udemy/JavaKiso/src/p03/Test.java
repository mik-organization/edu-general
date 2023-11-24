package p03;

public class Test {
	void f() {
		
	}
	
	void f(int x) {
		
	}
	
	void f(float x) {
		
	}
}
/*オーバーロード(同じ名前のメソッドを複数定義する)ができる条件
①引数の数が違う。
②引数のデータ型が違う。*/
/*注意点
public class Test {
void f(int x) {
	
}

void f(int y) {
	
}
ではオーバーロードできない。
データ型は同じであるため、
引数の変数名を変えたからといってオーバーロードできるわけではない。*/