package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.IdealException;
import model.User;

/**
 * Servlet implementation class UserOperationSvl
 */
@WebServlet("/UserOperationSvl")
public class UserOperationSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//ファイナル変数宣言
	public static final int INSERT = 11; //登録処理
	public static final int UPDATE = 12; //変更処理
	public static final int DELETE = 13; //削除処理
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOperationSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//初期化
		RequestDispatcher rd = null; //ディスパッチャー変数の宣言
		String url = ""; //URLを格納
		HttpSession session = request.getSession(false); //sessionオブジェクトの取得
		User userInfo = (User)session.getAttribute("userInfo");
		User u;
		
		/* requestとresponseの文字コード設定 */
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int mode;

		try{ //modeを数値に変換
			mode = Integer.parseInt(request.getParameter("mode"));
			if(mode != 11 && userInfo == null) {
				url = "home.jsp";
			}
		}catch(NumberFormatException e){ //変換できない時はトップ画面に行く定数を設定
			url = "home.jsp";
		}
		//AttributeにUserの全てを格納
		request.setAttribute("user", User.getUser(userInfo.getUsrId()));
		
		//Userオブジェクトを生成
		u = new User();
		//パラメーターからデータを取得してBeanにセット、顧客情報(User)を生成する
		u.setUsrId(Integer.parseInt(request.getParameter("useId")));	//登録の時はnullが入るけど、特に使用されないので大丈夫
		u.setUsrName(request.getParameter("usrName"));
		u.setPassword(request.getParameter("password"));
		u.setAddress(request.getParameter("address"));
		u.setPhone(request.getParameter("phone"));
		u.setMail(request.getParameter("mail"));


		//処理モード（mode）により処理を分岐する。
		switch(mode) {

			case INSERT: //登録処理
				try {
				//DBにINSERT User.javaの方でinsertメソッド未FIX
				User.insert(u);
				//セッション(userInfo)に取得した顧客IDで顧客テーブルより顧客情報を取得し、設定
				session.setAttribute("userInfo", User.getUser(u.getUsrId()));
				//URLを「顧客情報登録画面（JSP）」に設定
				url = "/userInsertCompletion.jsp";
				break;
				//独自例外
				}catch (IdealException e) {
					e.setErrCd(0);
					request.setAttribute("msg", e.getMsg());
					request.setAttribute("user", u);
					url = "/userInsert.jsp";	//urlに「顧客情報登録画面（JSP）」セット
				}
			case UPDATE: //変更処理
				try {
				//DBにUPDATE
				User.update(u);
				//セッション(userInfo)に変更した顧客情報を取得し、設定
				session.setAttribute("userInfo", User.getUser(u.getUsrId()));
				//URLを「顧客処理選択画面（JSP）」に設定
				url = "/userIndex.jsp";
				break;
				//独自例外
				}catch (IdealException e) {
					e.setErrCd(0);
					request.setAttribute("msg", e.getMsg());
					request.setAttribute("user", u);
					url =  "/controller/UserUpdateSvl.java";	//urlに「顧客情報変更画面表示処理（Servlet）」セット
				}
			case DELETE: //削除処理
				try {
				//DBにDALETE User.javaの方でdeleteメソッド未FIX
				User.dalete(u);
				//セッション情報を削除
				session.invalidate();
				//URLを「ホームページ（JSP）」に設定
				url = "/home.jsp";
				break;
				//独自例外
				}catch (IdealException e) {
					e.setErrCd(0);
					request.setAttribute("msg", e.getMsg());
					request.setAttribute("user", u);;
					url =  "/controller/UserUpdateSvl.java";	//urlに「顧客情報変更画面表示処理（Servlet）」セット
				}
			default:	
				break;
		}
		//ページをフォワーディングする
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}

