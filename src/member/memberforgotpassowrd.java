package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import source.login;
import management.DAO;

/**
 * Servlet implementation class memberforgotpassowrd
 */
@WebServlet("/memberforgotpassowrd")
public class memberforgotpassowrd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberforgotpassowrd() {
        super();
        // TODO Auto-generated constructor stub
        dao = new DAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String email = request.getParameter("email");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		String pass = pass1.equals(pass2)?pass1:"f";
		
		login passwordReset = new login("", email, pass, "");
		
		try {
			login exist = dao.selectMemberExist(email);
			if(exist != null) {
				if(!pass.equals("f")) {
					dao.updateMemberPassword(passwordReset);
					pw.print("<h3 style=\"color: white\">Password reset!!</h3>");
					RequestDispatcher rdlogin = request.getRequestDispatcher("index.html");
					rdlogin.include(request, response);
				}
				else {
					pw.print("<h3 style=\"color: white\">value of password is different from the confirmation</h3>");
					RequestDispatcher rdlogin = request.getRequestDispatcher("forgotpassword.html");
					rdlogin.include(request, response);
				}
			}
			else {
				pw.print("<h3 style=\"color: white\">Account not exist!!</h3>");
				RequestDispatcher rdlogin = request.getRequestDispatcher("forgotpassword.html");
				rdlogin.include(request, response);
			}
					
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
