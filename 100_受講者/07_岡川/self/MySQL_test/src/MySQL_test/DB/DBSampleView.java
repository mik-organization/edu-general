package MySQL_test.DB;

import java.sql.SQLException;

public class DBSampleView {
	public void View() {
		try {
			var BaseDao = new BaseDao();
			var con = BaseDao.getConnection();
			System.out.println("接続成功");
			BaseDao.TableView(con);
		} catch (SQLException e) {
			System.out.println("接続失敗" + e.getMessage());
		}

	}
}