package chap10;

public class Thread09 {

	public static void main(String[] args) {

		Microthread09 mt = new Microthread09();
		Widethread09 wt = new Widethread09();
		
		Thread m=new Thread(mt);
		Thread w=new Thread(wt);
		
		m.start();
		w.start();

		for (int i = 0; i <= 10; i++) {
			System.out.println("Main" + i);
		}
		
		System.out.println("---End---");
	}
	
}
