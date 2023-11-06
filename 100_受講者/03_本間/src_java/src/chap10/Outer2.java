package chap10;

public class Outer2{
	class A{ // static でないクラス
		void methA(){
			System.out.println("methA");
		}
	}
	static class B{ // static クラス
		static void methB(){
			System.out.println("methB");
		}
	}
	public void meth0(){
		new A().methA(); // static でないクラス/メソッドの呼び出し
	}
	public void meth1(){ // static クラス/メソッドの呼び出し
		B.methB();
	}
	public void meth2(){ // static クラス/メソッドの呼び出しは
		new B().methB(); // このように記述もできます
	}
}
