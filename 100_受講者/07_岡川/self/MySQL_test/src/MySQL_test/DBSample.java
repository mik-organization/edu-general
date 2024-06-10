package MySQL_test;

import java.util.Scanner;

import MySQL_test.DB.DBSampleDelete;
import MySQL_test.DB.DBSampleInput;
import MySQL_test.DB.DBSampleView;

public class DBSample {
	public static void main(String[] args) {

		System.out.println("1:情報の閲覧");
		System.out.println("2:情報の追加");
		System.out.println("3:情報の削除");
		System.out.println("9:終了する");

		var isExit = true;
		while (isExit) {

			System.out.println();
			var scan = new Scanner(System.in);
			System.out.print("希望する操作の入力：");
			var select = scan.nextInt();

			switch (select) {

			case 1:
				var view = new DBSampleView();
				view.view();
				break;

			case 2:
				var input = new DBSampleInput();
				input.input();
				break;

			case 3:
				var delete = new DBSampleDelete();
				delete.delete();
				break;

			case 9:
				System.out.println("終了します。");
				isExit = false;
				scan.close();
				break;

			default:
				System.out.println("入力エラーです");
				break;
			}
		}
	}
}