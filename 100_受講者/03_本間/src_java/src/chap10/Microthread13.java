package chap10;

//Thread のサブクラスを作ります。
public class Microthread13 extends Thread{
	
	@Override
	public void run(){ // run メソッド内に処理を記述します。
		for(int i = 0 ; i <= 10 ; i++){
			System.out.println("Micro"+i);
			try {
				// Threadのstaticメソッドのsleep()を呼び出す
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
