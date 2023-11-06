package chap10;

public class AnonymousThread15 {
	public static void main(String[] args) {
		
		Runnable mt = new Runnable(){ //Runnableインターフェースを実装した匿名クラス
			@Override
			public void run(){ //run()を実装
				for(int i = 0 ; i <= 10 ; i++){
					System.out.println("Micro" + i);
				}
			}
		};
		Thread t = new Thread(mt); //mtをパラメーターにして
		//Threadクラスのインスタンスを生成
		t.start(); //startメソッドでrunメソッドを実行します。
		new Thread(new Runnable(){ //Threadクラスのコンストラクターのパラメーターに
			//Runnableインターフェースを実装した匿名クラスを定義
			@Override
			public void run(){ //run()を実装
				for(int i = 0 ; i <= 10 ; i++){
					System.out.println("\tWide" + i);
				}
			}
		}).start(); //Threadクラスのstart()メソッドを呼び出す
		System.out.println("--- End ---");
	}
}











