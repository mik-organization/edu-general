package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	//フィールド
	private int usrId;
	private String usrName;
	private String password;
	private String address;
	private String phone;
	private String mail;
	private String exp;

	//コンストラクタ
	public User() {//コンストラクタ
		super();
	}

	//	--------------↓ゲッターメソッド-------------------
	public int getUsrId() {
		return usrId;
	}

	public String getUsrName() {
		return usrName;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getMail() {
		return mail;
	}

	public String getExp() {
		return exp;
	}

	//	--------------↓セッターメソッド-------------------
	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	// ---↓各メソッド--- 独自例外（IdealException）は組み込めていません

	public static User login(int usrId, String password) {
		Connection con = null;
		DataSource ds = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mariadb");
			con = ds.getConnection();

			String sql = "select * from user where usr_id=? and password= password(?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, usrId);
			pst.setString(2, password);

			rs = pst.executeQuery();
			User u = new User();
			if (rs.next()) {
				u.setUsrId(rs.getInt("usr_id"));
				u.setUsrName(rs.getString("usr_name"));
				u.setPassword(rs.getString("password"));
				u.setAddress(rs.getString("address"));
				u.setPhone(rs.getString("phone"));
				u.setExp(rs.getString("exp"));
			} else {
				u = null;
			}
		} catch (Exception e) {
			System.out.println("SQL= " + sql);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) {

			}
		}
		return u;
	}

	public static User getUser(int usrId) throws SQLException {
		Connection con = null;
		DataSource ds = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mariadb");
			con = ds.getConnection();

			String sql = "select * from user where usr_id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, usrId);

			rs = pst.executeQuery();
			User u = new User();
			if (rs.next()) {
				u.setUsrId(rs.getInt("usr_id"));
				u.setUsrName(rs.getString("usr_name"));
				u.setPassword(rs.getString("password"));
				u.setAddress(rs.getString("address"));
				u.setPhone(rs.getString("phone"));
				u.setExp(rs.getString("exp"));
			} else {
				u = null;
			}
		} catch (Exception e) {
			System.out.println("SQL= " + sql);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) {

			}
		}
		return u;

	}

	public static User insert(User user) {
		InitialContext ic = null;
		Connection con = null;
		DataSource ds = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		User u = user;
		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mariadb");
			con = ds.getConnection();

			sql = "INSERT INTO user VALUES( DEFAULT,?,?,?,?,?.?)";

			pst = con.prepareStatement(sql);
			pst.setString(1, u.getUsrName());
			pst.setString(2, u.getPassword());
			pst.setString(3, u.getAddress());
			pst.setString(4, u.getPhone());
			pst.setString(5, u.getMail());
			pst.setString(6, u.getExp());
		
			if (pst.executeUpdate() > 0) {
				sql = "select last_insert_id()";
				// pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
			}

			if (rs.next()) {
				u = new User();
				u.setUsrId(rs.getInt("usr_id"));
			}

		} catch (Exception e) {
			System.out.println("SQL= " + sql);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) {

			}
		}
		return u;
	}

	public static User update(User user) {
		InitialContext ic = null;
		Connection con = null;
		DataSource ds = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		User u = user;

		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mariadb");
			con = ds.getConnection();

			sql = "update user set usr_name = ?, password = ?, address = ?, phone = ?, mail = ?, exp = ?";
			pst = con.prepareStatement(sql);

			pst.setString(1, u.getUsrName());
			pst.setString(2, u.getPassword());
			pst.setString(3, u.getAddress());
			pst.setString(4, u.getPhone());
			pst.setString(5, u.getMail());
			pst.setString(6, u.getExp());

			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("SQL= " + sql);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) {

			}
		}
		return u;
	}

	public static void delete(User user) {
		InitialContext ic = null;
		Connection con = null;
		DataSource ds = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		User u = user;
	
		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mariadb");
			con = ds.getConnection();
	
			sql = "delete from reserve where usr_id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, u.getUsrId());
	
			pst.executeUpdate();
	
			sql = "delete from user where usr_id = ?";
			pst.setInt(1, u.getUsrId());
	
			pst.executeUpdate();
	
		} catch (Exception e) {
			System.out.println("SQL= " + sql);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
	
			}
		}
	
	}

}
