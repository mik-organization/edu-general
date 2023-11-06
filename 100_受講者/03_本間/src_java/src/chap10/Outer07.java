package chap10;

public class Outer07 {
	
	static int si = 0;
	int ci = 1;

	void meth0(int di, final int fi) { // fiはfinal
		int mi0 = 2;
		final int mi1 = 3;
		new SuperInter07() {

			@Override
			public void meth1() {

				System.out.println("si=" + si);
				System.out.println("ci=" + ci);
				System.out.println("mi0=" + mi0);
				System.out.println("mi1=" + mi1);
				System.out.println("di=" + di);
				System.out.println("fi=" + fi);

			}
		}.meth1();

	}
}
