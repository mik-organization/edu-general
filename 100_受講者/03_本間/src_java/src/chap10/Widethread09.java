package chap10;

public class Widethread09 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("\t\tWide" + i);
		}
	}
}
