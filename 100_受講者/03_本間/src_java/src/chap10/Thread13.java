package chap10;

public class Thread13 {

	public static void main(String[] args) {
		//インスタンス化
		Microthread13 mt = new Microthread13();
		//mtのスレッドをスタート
		mt.start();
		try{
			mt.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("-----END-----");

	}

}
