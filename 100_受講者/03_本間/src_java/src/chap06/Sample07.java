package chap06;

class Super07 {
	int i = 0;

	void writeln() {
		System.out.println("Super");
	}
}

class Sub07 extends Super07 {
	int i = 1;

	void writeln() {
		System.out.println("sub");
	}
}

public class Sample07 {

	public static void main(String[] args) {

		// 親型のsaに、子のオブジェクトを与える
		Super07 sa = new Sub07();

		System.out.println(sa.i); // ここのsaは親型なので、親クラスの変数iを参照する
		sa.writeln(); // 同名メソッドは継承された新しいほうに置き換えて呼び出される

		/*
		 上の実行すると、
		 
		0
		sub
		
		と表示されるが、
		sa の頭にある型を優先するので、親側の値が参照される
		ただし、同名メソッドがある場合には、新しいもの（今回はsub）の内容に
		置き換えられて、参照されるため、
		この例では継承された子クラスのメソッドが参照され、表示される
		 
		 
		 */

	}

}
