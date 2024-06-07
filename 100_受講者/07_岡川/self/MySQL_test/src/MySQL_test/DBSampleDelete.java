package MySQL_test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

class DBSampleDelete {
	public void Delete() {
		final var ID = ("root");
		final var PASS = ("9qg3ypnusql");
		final var URL = ("jdbc:mysql://localhost:3306/sample");

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
