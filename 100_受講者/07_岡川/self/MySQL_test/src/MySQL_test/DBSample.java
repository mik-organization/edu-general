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

		while (isExit == true) {

			System.out.println();
			System.out.print("希望する操作の入力：");
			var scan = new Scanner(System.in);
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
		final var id = ("root");
		final var Pass = ("9qg3ypnusql");
		final var url = ("jdbc:mysql://localhost:3306/sample");

		var sql = "SELECT * FROM vegetable";

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//調べると上記必要と記載あるが無くても実行出来た。
			//必要な場合と不必要な場合の違いは解らず。

			var con = DriverManager.getConnection(url, id, Pass);
			System.out.println("接続成功");
			System.out.println();
			var ps = con.prepareStatement(sql);
			var rs = ps.executeQuery();

			while (rs.next()) {
				var Uid = rs.getString("id");
				var Uname = rs.getString("name");
				var Upay = rs.getString("price");

				System.out.println(Uid + ":" + Uname + ":" + Upay + "円");

			}

		} catch (SQLException e) {
			System.out.println("接続失敗" + e.getMessage());
		}

	}
}

class DBSampleInput {
	public void Input() {

		final var id = ("root");
		final var Pass = ("9qg3ypnusql");
		final var url = ("jdbc:mysql://localhost:3306/sample");

		var sqlInput = "insert into vegetable values(?,?,?);";

		try {
			var con = DriverManager.getConnection(url, id, Pass);
			System.out.println("接続成功");
			System.out.println();
			var ps = con.prepareStatement(sqlInput);

			var sc = new Scanner(System.in);

			System.out.print("IDを入力：");
			var ids = Integer.parseInt(sc.nextLine());

			System.out.print("商品名を入力：");
			var name = sc.nextLine();

			System.out.print("値段を入力：");
			var price = Integer.parseInt(sc.nextLine());

			ps.setInt(1, ids);
			ps.setString(2, name);
			ps.setInt(3, price);

			ps.executeUpdate();

			System.out.println("追加されたデータは以下の通りです。");
			System.out.println(ids + ":" + name + ":" + price + "円");

		} catch (SQLException e) {
			System.out.println("接続失敗" + e.getMessage());
		}
	}
}

class DBSampleDelete {
	public void Delete() {
		final var id = ("root");
		final var Pass = ("9qg3ypnusql");
		final var url = ("jdbc:mysql://localhost:3306/sample");

		var sql = "SELECT * FROM vegetable";
		var sqlD = "delete from vegetable where name=?;";

		try {
			var con = DriverManager.getConnection(url, id, Pass);
			System.out.println("接続成功");
			System.out.println();
			var ps = con.prepareStatement(sql);
			var rs = ps.executeQuery();

			while (rs.next()) {
				var Uid = rs.getString("id");
				var Uname = rs.getString("name");
				var Upay = rs.getString("price");

				System.out.println(Uid + ":" + Uname + ":" + Upay + "円");

			}
			ps = con.prepareStatement(sqlD);
			var sc = new Scanner(System.in);
			System.out.print("消去する野菜を入力してください:");
			var Dname = sc.nextLine();

			ps.setString(1, Dname);
			ps.executeUpdate();

			System.out.println(Dname + "の情報を削除しました。");

		} catch (SQLException e) {
			System.out.println("接続失敗" + e.getMessage());
		}
	}
}