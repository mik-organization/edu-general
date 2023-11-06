package chap10;

public class Thread08 {

	public static void main(String[] args) {

		Microthread08 mt = new Microthread08();
		Widethread08 wt = new Widethread08();

		wt.start();
		mt.start();

		for (int i = 0; i <= 10; i++) {
			System.out.println("Main" + i);
		}
		
		System.out.println("---End---");
	}
	
}
