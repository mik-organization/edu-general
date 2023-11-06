package chap09;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {

		ArrayList scanCollection = new ArrayList();

		Scanner scan = new Scanner(System.in);
		String input = "";

		while (!input.equals("q")) {
			System.out.print("テキストを入力してください（qで終了します）：");
			input = scan.nextLine();
			

			if (!input.equals("q") && !input.equals("")) {
				scanCollection.add(input);
			}
			
		}
		scan.close();
		System.out.println("\n" + scanCollection.size() + "件入力されました。");

		System.out.println("\n//入力された情報を表示します//");
		for (int i = 0; i < scanCollection.size(); i++) {
			
			System.out.println(scanCollection.get(i));

		}
	}
}
