package MySQL_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBSample {
	public static void main(String[] args) {
		int exit = 0;

		System.out.println("情報の閲覧:閲覧");
		System.out.println("情報の追加:追加");
		System.out.println("情報の削除:削除");
		System.out.println("終了する  :exit");

		for (exit = 1; exit < 2; exit++) {

			System.out.println();
			System.out.print("希望する操作の入力：");
			Scanner scan = new Scanner(System.in);
			String select = scan.next();

			switch (select) {

			case "閲覧":
				DBSampleView view = new DBSampleView();
				view.View();
				exit--;
				break;

			case "追加":
				DBSampleInput input = new DBSampleInput();
				input.Input();
				exit--;
				break;

			case "削除":
				DBSampleDelete delete = new DBSampleDelete();
				delete.Delete();
				exit--;
				break;

			case "exit":
				System.out.println("終了します。");
				exit++;
				break;

			default:
				System.out.println("入力エラーです");
				exit--;
				break;
			}
		}
	}
}

class DBSampleView {
	public void View() {
		final String id = ("root");
		final String Pass = ("9qg3ypnusql");
		final String url = ("jdbc:mysql://localhost:3306/sample");

		Connection con = null;
		ResultSet rs = null;
		//PreparedStatement ps =null;
		//エラーになる為ここでの宣言はせず。

		String sql = "SELECT * FROM yasais";

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//調べると上記必要と記載あるが無くても実行出来た。
			//必要な場合と不必要な場合の違いは解らず。

			con = DriverManager.getConnection(url, id, Pass);
			System.out.println("接続成功");
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String Uid = rs.getString("id");
				String Uname = rs.getString("name");
				String Upay = rs.getString("値段");

				System.out.println(Uid + ":" + Uname + ":" + Upay + "円");

			}

		} catch (SQLException e) {
			System.out.println("接続失敗" + e.getMessage());
		}

	}
}

class DBSampleInput {
	public void Input() {
		int ids = 0;
		String name = null;
		int price = 0;

		final String id = ("root");
		final String Pass = ("9qg3ypnusql");
		final String url = ("jdbc:mysql://localhost:3306/sample");

		String sqlInput = "insert into yasais values(?,?,?);";

		try {
			Connection con = DriverManager.getConnection(url, id, Pass);
			System.out.println("接続成功");
			PreparedStatement ps = con.prepareStatement(sqlInput);

			Scanner sc = new Scanner(System.in);

			System.out.print("IDを入力：");
			ids = Integer.parseInt(sc.nextLine());

			System.out.print("商品名を入力：");
			name = sc.nextLine();

			System.out.print("値段を入力：");
			price = Integer.parseInt(sc.nextLine());

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
		final String id = ("root");
		final String Pass = ("9qg3ypnusql");
		final String url = ("jdbc:mysql://localhost:3306/sample");

		Connection con = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM yasais";
		String sqlD = "delete from yasais where name=?;";

		try {
			con = DriverManager.getConnection(url, id, Pass);
			System.out.println("接続成功");
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String Uid = rs.getString("id");
				String Uname = rs.getString("name");
				String Upay = rs.getString("値段");

				System.out.println(Uid + ":" + Uname + ":" + Upay + "円");

			}
			ps = con.prepareStatement(sqlD);
			Scanner sc = new Scanner(System.in);
			System.out.print("消去する野菜を入力してください:");
			String Dname = sc.nextLine();

			ps.setString(1, Dname);
			ps.executeUpdate();

			System.out.println(Dname + "の情報を削除しました。");

		} catch (SQLException e) {
			System.out.println("接続失敗" + e.getMessage());
		}
	}
}