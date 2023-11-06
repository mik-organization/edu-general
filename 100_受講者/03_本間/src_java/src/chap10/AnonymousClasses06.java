package chap10;

public class AnonymousClasses06 {
	public static void main(String[] args) {

		new Super04() {
			@Override
			public void meth() {
				System.out.println("str = " + str);
			}
		}.meth();

	}
}
