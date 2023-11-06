package chap06;

public class InterSub43 implements InterSuper43A, InterSuper43B {
	@Override
	public void methodA() { // 実装①
		System.out.println("メソッドA");
	}

	@Override
	public void methodB() { // 実装②
		System.out.println("メソッドB");
	}
	
	@Override
	public void method() {
		System.out.println("InterSub43");
		InterSuper43A.super.method();
	}

}
