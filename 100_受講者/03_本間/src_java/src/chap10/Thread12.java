package chap10;

public class Thread12 {

	public static void main(String[] args) {

		Microthread08 mt = new Microthread08();
		Widethread08 wt = new Widethread08();
		
		mt.setPriority(Thread.MAX_PRIORITY);
		wt.setPriority(3);
		
		System.out.println("Microの優先順位"+mt.getPriority());
		System.out.println("Wideの優先順位"+wt.getPriority());
		System.out.println("---Start---");
		
		mt.start();
		wt.start();

		for (int i = 0; i <= 10; i++) {
			System.out.println("Main" + i);
		}
		
		try {
			mt.join();
			wt.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("---End---");
	}

}
