package MySQL_test.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class DBSampleInput {
	public void input() {
		try {
			var BaseDao = new BaseDao();
			Connection con = BaseDao.getConnection();
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