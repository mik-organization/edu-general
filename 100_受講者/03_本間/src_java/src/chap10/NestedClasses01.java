package chap10;

public class NestedClasses01 {

	public static void main(String[] args) {

		// staticでないクラスのインスタンス化
		Outer1.A a = new Outer1().new A();
		a.meth0();

		// staticクラスのインスタンス化
		Outer1.B b = new Outer1.B();
		b.meth1();

		// staticなメンバはインスタンス生成しなくても参照できます。
		System.out.println("bi=" + Outer1.B.bi);

	}

}
