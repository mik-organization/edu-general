package chap06;

public class Sample44 {

	public static void main(String[] args) {
		InterSuper44 inter1 = new InterSub44A(); //2つの実装クラスのインスタンスを
		InterSuper44 inter2 = new InterSub44B(); //同じ型に代入
		inter1.method(); //同じメソッド名で呼び出し、
		inter2.method(); //表示内容は変わる Sub1とSub2
		System.out.println(inter1.NAME); // InterSuper44のNAMEフィールドを参照
		System.out.println(inter2.NAME); // InterSuper44のNAMEフィールドを参照
		/* InterSuper44のnameフィールドを参照は
		System.out.println(InterSuper44. NAME);
		でも同じ。
		*/
	}

}
