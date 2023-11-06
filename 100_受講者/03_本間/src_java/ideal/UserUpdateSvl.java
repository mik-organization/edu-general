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

/**
 * Servlet implementation class UserUpdateSvl
 */
@WebServlet("/UserUpdateSvl")
public class UserUpdateSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateSvl() {
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
		
				RequestDispatcher rd = null;
				String url = ""; //URLを格納するStringオブジェクト
				
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				HttpSession session;
				
					try {
						session = request.getSession(true);
						try {
							request.setAttribute("user", session.getAttribute("usrID"));
							url="/userUpdate.jsp";
							}catch(Exception e) {
								IdealException ie = new IdealException(1);
								ie.setErrCd(0);
								ie.getMsg();
								url="/userIndex.jsp";
							}
					}catch(NumberFormatException e) {
					url= "/home.jsp";
					}
					
					rd = request.getRequestDispatcher(url);
					rd.forward(request,response);
					
			}

}
