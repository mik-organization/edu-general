package chap08;

import java.util.Scanner;

public class Ex13 {
	public static void main(String[] args) {

		//StringBufferクラスのオブジェクトを生成
		StringBuffer sb = new StringBuffer();
		
		//コンソールからの入力値変数を宣言
		Scanner scan = new Scanner(System.in);
		String input = "";
		
		//"q"が入力されるまで繰り返し
		while (!input.equals("q")) {
			//入力のメッセージを表示
			System.out.print("■文字列を入力してください：");
			input = scan.nextLine();
			
			if(!input.equals("q")) {
			sb.append(input);
			}
		}

		scan.close();
		System.out.println("\n" + sb);

	}
}