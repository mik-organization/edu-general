package chap10;

public class AnonymousThread14 {
	public static void main(String[] args) {
		
		 //Threadクラスのサブクラスとして匿名クラスを定義
		Thread mt = new Thread(){
			@Override
			public void run(){ //run()メソッドをオーバーライド
				for(int i = 0 ; i <= 10 ; i++){
					System.out.println("Micro" + i);
				}
			}
		};
		mt.start(); //startメソッドで実行
		
		/*Threadクラス型の変数に代入せずに一気にstart()を呼び出す*/
		new Thread(){ //Threadクラスのサブクラスとして匿名クラスを定義
			//Widethreadクラスを作らずに匿名クラスで処理
			@Override
			public void run(){ //run()メソッドをオーバーライド
				for(int i = 0 ; i <= 10 ; i++){
					System.out.println("\tWide" + i);
				}
			}
		}.start(); //インスタンスから直接start()メソッドを呼び出す
		try {
			mt.join();
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println("--- End ---");
	}
}








