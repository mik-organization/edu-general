package MySQL_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBSample {
	public static void main(String[] args) {

		System.out.println("1:情報の閲覧");
		System.out.println("2:情報の追加");
		System.out.println("3:情報の削除");
		System.out.println("9:終了する");

		boolean isExit = true;
		while (isExit) {

			System.out.println();
			System.out.print("希望する操作の入力：");
			Scanner scan = new Scanner(System.in);
			int select = scan.nextInt();

			switch (select) {

			case 1:
				DBSampleView view = new DBSampleView();
				view.View();
				break;

			case 2:
				DBSampleInput input = new DBSampleInput();
				input.Input();
				break;

			case 3:
				DBSampleDelete delete = new DBSampleDelete();
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
		final String ID = ("root");
		final String PASS = ("9qg3ypnusql");
		final String URL = ("jdbc:mysql://localhost:3306/sample");

		final String SQL = "SELECT * FROM yasais";

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//調べると上記必要と記載あるが無くても実行出来た。
			//必要な場合と不必要な場合の違いは解らず。

			Connection con = DriverManager.getConnection(URL, ID, PASS);
			System.out.println("接続成功");
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String ids = rs.getString("id");
				String name = rs.getString("name");
				String pay = rs.getString("値段");

				System.out.println(ids + ":" + name + ":" + pay + "円");

			}

		} catch (SQLException e) {
			System.out.println("接続失敗" + e.getMessage());
		}

	}
}

class DBSampleInput {
	public void Input() {

		final String ID = ("root");
		final String PASS = ("9qg3ypnusql");
		final String URL = ("jdbc:mysql://localhost:3306/sample");

		String sqlinput = "insert into yasais values(?,?,?);";

		try {
			Connection con = DriverManager.getConnection(URL, ID, PASS);
			System.out.println("接続成功");
			PreparedStatement ps = con.prepareStatement(sqlinput);

			Scanner sc = new Scanner(System.in);

			System.out.print("IDを入力：");
			int ids = Integer.parseInt(sc.nextLine());

			System.out.print("商品名を入力：");
			String name = sc.nextLine();

			System.out.print("値段を入力：");
			int price = Integer.parseInt(sc.nextLine());

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
		final String ID = ("root");
		final String PASS = ("9qg3ypnusql");
		final String URL = ("jdbc:mysql://localhost:3306/sample");

		final String SQL = "SELECT * FROM yasais";
		String sqldelete = "delete from yasais where name=?;";

		try {
			Connection con = DriverManager.getConnection(URL, ID, PASS);
			System.out.println("接続成功");
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String ids = rs.getString("id");
				String name = rs.getString("name");
				String pay = rs.getString("値段");

				System.out.println(ids + ":" + name + ":" + pay + "円");

			}
			ps = con.prepareStatement(sqldelete);
			Scanner sc = new Scanner(System.in);
			System.out.print("消去する野菜を入力してください:");
			String dname = sc.nextLine();

			ps.setString(1, dname);
			ps.executeUpdate();

			System.out.println(dname + "の情報を削除しました。");

		} catch (SQLException e) {
			System.out.println("接続失敗" + e.getMessage());
		}
	}
}