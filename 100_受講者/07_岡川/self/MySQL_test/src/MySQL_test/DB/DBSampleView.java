package MySQL_test.DB;

import java.sql.SQLException;

public class DBSampleView {
	public void view() {
		try {
			var BaseDao = new BaseDao();
			var con = BaseDao.getConnection();
			BaseDao.tableView(con);
		} catch (SQLException e) {
			System.out.println("接続失敗" + e.getMessage());
		}

	}
}