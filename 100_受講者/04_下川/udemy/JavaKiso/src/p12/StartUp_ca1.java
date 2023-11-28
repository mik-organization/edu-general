//例外01　try～catch文で例外処理を行う＆try～catch～finally文で例外処理を行う
//例外処理とは、例外が発生した時のエラーの対処のこと。

package p12;

public class StartUp_ca1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			int result = 10/0;
			System.out.println(result);
			//発生する可能性があるプログラムをtryブロック内に記述する。
		}catch(ArithmeticException e) {
		//↑()内には発生する可能性がある例外を記述する。スローされた例外を受け取る変数名は「e」が一般的。
		//catchブロックにはスローされた例外をキャッチする部分と、例外が発生した時の処理を記述する。	
			System.out.println("0で割れませんよ！");
		}finally {
			System.out.println("終了します。");
			//例外が発生してもしなくても最後に実行する処理。
		}
		

	}

}
