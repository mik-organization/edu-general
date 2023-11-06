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
 * Servlet implementation class AdnubLoginSvl
 */
@WebServlet("/UserLoginSvl")
public class UserLoginSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		RequestDispatcher rd = null;
		//取得するべきもの 顧客ID(usrId)、パスワード(password)
		int usrId;
		String password = null;
		System.out.println("UserLoginSvl try前");
		HttpSession session = request.getSession(true);
		//データ取得に失敗したらCatchに行くという想定で作成しているが、もし行かない場合は
		//Nullや0などの初期値を条件としてThrowする

		try {
			System.out.println("UserLoginSvl try中");

			usrId = Integer.parseInt(request.getParameter("usrId"));
			password = request.getParameter("password");
			try{
				User user = User.login(usrId, password);
				if(user != null) {
					System.out.println("UserLoginSvl User != null の中");

					session.setAttribute("userInfo", user);
					rd = request.getRequestDispatcher("userIndex.jsp");
					rd.forward(request, response);
					return;
				}else{
					System.out.println("UserLoginSvl User != null のelse");
					session.setAttribute("userInfo", null);
					IdealException ie = new IdealException();
					ie.setErrCd(2);
					request.setAttribute("msg",ie.getMsg());

					rd = request.getRequestDispatcher("userLogin.jsp");
					rd.forward(request, response);
					return;	
				}
			
			}catch(Exception e) {
			System.out.println("Exception Catch");

			e.printStackTrace();
			IdealException ie = new IdealException(3);
			request.setAttribute("msg",ie.getMsg());

			rd = request.getRequestDispatcher("userLogin.jsp");
			rd.forward(request, response);
			}	
		}finally {
			System.out.println("UserLoginSvl User != null finally");
		}
		
		}

}
