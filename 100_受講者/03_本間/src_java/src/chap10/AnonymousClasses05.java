package chap10;

public class AnonymousClasses05 {
	public static void main(String[] args) {

		Super04 spr = new Super04() {
			@Override
			public void meth() {
				System.out.println("str = " + str);
			}
		};
		spr.meth();
	}
}
