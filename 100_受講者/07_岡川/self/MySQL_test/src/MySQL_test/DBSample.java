package MySQL_test;

import java.util.Scanner;

import DB.DBSampleDelete;
import DB.DBSampleInput;
import DB.DBSampleView;

public class DBSample {
	public static void main(String[] args) {
		var isExit = true;

		System.out.println("1:情報の閲覧");
		System.out.println("2:情報の追加");
		System.out.println("3:情報の削除");
		System.out.println("9:終了する");

		while (isExit) {

			System.out.println();
			var scan = new Scanner(System.in);
			System.out.print("希望する操作の入力：");
			var select = scan.nextInt();

			switch (select) {

			case 1:
				var view = new DBSampleView();
				view.View();
				break;

			case 2:
				var input = new DBSampleInput();
				input.Input();
				break;

			case 3:
				var delete = new DBSampleDelete();
				delete.Delete();
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