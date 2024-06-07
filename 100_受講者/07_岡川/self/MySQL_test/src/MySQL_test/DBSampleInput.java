package MySQL_test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

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