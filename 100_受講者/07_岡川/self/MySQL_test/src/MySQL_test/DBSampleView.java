package MySQL_test;

import java.sql.DriverManager;
import java.sql.SQLException;

class DBSampleView {
	public void View() {
		final var ID = ("root");
		final var PASS = ("9qg3ypnusql");
		final var URL = ("jdbc:mysql://localhost:3306/sample");

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