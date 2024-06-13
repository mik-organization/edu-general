package MySQL_test.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	static final String ID = "root";
	static final String PASS = "9qg3ypnusql";
	static final String URL = "jdbc:mysql://localhost:3306/sample";

	public Connection getConnection() throws SQLException {

		return DriverManager.getConnection(URL, ID, PASS);

	}

	public void tableView(Connection con) {
		try {
			final var SQL = "SELECT * FROM vegetable";
			var ps = con.prepareStatement(SQL);
			var rs = ps.executeQuery();
			System.out.println("---接続成功---");

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
