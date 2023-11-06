package chap06;

public class Sample43 {
	public static void main(String[] args) {
		/* それぞれのインターフェース型に実装クラスのインスタンスを代入 */
		InterSuper43A interA = new InterSub43();
		InterSuper43B interB = new InterSub43();
		
		System.out.println(InterSuper43A.NAME);
		System.out.println(InterSuper43B.NAME);
		
		interA.methodA();
		interB.methodB();
		
		interA.method();
		interB.method();
	}
}