package MySQL_test.DB;

import java.sql.SQLException;
import java.util.Scanner;

public class DBSampleDelete {
	public void delete() {

		try {
			var BaseDao = new BaseDao();
			var con = BaseDao.getConnection();
			System.out.println("接続成功");
			BaseDao.tableView(con);

			final var SQL_DELETE = "delete from vegetable where name=?;";
			var ps = con.prepareStatement(SQL_DELETE);

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
