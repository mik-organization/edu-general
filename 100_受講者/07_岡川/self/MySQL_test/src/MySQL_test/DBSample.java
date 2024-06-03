package MySQL_test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

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

class DBSampleView {
	public void View() {
		final var ID = "root";
		final var PASS = "9qg3ypnusql";
		final var URL = "jdbc:mysql://localhost:3306/sample";

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//調べると上記必要と記載あるが無くても実行出来た。
			//必要な場合と不必要な場合の違いは解らず。

			var con = DriverManager.getConnection(URL, ID, PASS);
			System.out.println("接続成功");

			final var SQL = "SELECT * FROM vegetable";
			var ps = con.prepareStatement(SQL);
			var rs = ps.executeQuery();

			while (rs.next()) {
				var id = rs.getString("id");
				var name = rs.getString("name");
				var pay = rs.getString("price");

				System.out.println(id + ":" + name + ":" + pay + "円");

			}

		} catch (SQLException e) {
			System.out.println("接続失敗" + e.getMessage());
		}

	}
}

class DBSampleInput {
	public void Input() {

		final var ID = "root";
		final var PASS = "9qg3ypnusql";
		final var URL = "jdbc:mysql://localhost:3306/sample";

		try {
			var con = DriverManager.getConnection(URL, ID, PASS);
			System.out.println("接続成功");

			var sc = new Scanner(System.in);
			System.out.print("IDを入力：");
			var id = Integer.parseInt(sc.nextLine());

			System.out.print("商品名を入力：");
			var name = sc.nextLine();

			System.out.print("値段を入力：");
			var price = Integer.parseInt(sc.nextLine());

			final var SQL_INPUT = "insert into vegetable(id,name,price) values(" + id + ",'" + name + "'," + price
					+ ");";
			var ps = con.prepareStatement(SQL_INPUT);

			ps.executeUpdate();

			System.out.println("追加されたデータは以下の通りです。");
			System.out.println(id + ":" + name + ":" + price + "円");

		} catch (SQLException e) {
			System.out.println("接続失敗" + e.getMessage());
		}
	}
}

class DBSampleDelete {
	public void Delete() {
		final var ID = "root";
		final var PASS = "9qg3ypnusql";
		final var URL = "jdbc:mysql://localhost:3306/sample";

		try {
			var con = DriverManager.getConnection(URL, ID, PASS);
			System.out.println("接続成功");

			final var SQL = "SELECT * FROM vegetable";
			var ps = con.prepareStatement(SQL);
			var rs = ps.executeQuery();

			while (rs.next()) {
				var id = rs.getString("id");
				var name = rs.getString("name");
				var pay = rs.getString("price");

				System.out.println(id + ":" + name + ":" + pay + "円");

			}
			final var SQL_DELETE = "delete from vegetable where name=?;";
			ps = con.prepareStatement(SQL_DELETE);

			var sc = new Scanner(System.in);
			System.out.print("消去する野菜を入力してください:");
			var deleteName = sc.nextLine();

			ps.setString(1, deleteName);
			ps.executeUpdate();

			System.out.println(deleteName + "の情報を削除しました。");

		} catch (SQLException e) {
			System.out.println("接続失敗" + e.getMessage());
		}
	}
}