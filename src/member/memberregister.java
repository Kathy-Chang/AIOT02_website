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
 * Servlet implementation class memberregister
 */
@WebServlet("/memberregister")
public class memberregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberregister() {
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
		
		String NewAct = request.getParameter("email");
		String password = request.getParameter("pass");
		String number = request.getParameter("number");
		
		login newAccount = new login("", NewAct, password, number);
		
		try {
			login exist = dao.selectMemberExist(NewAct);
			if(exist == null) {
				dao.insertMember(newAccount);
				pw.print("<h3 style=\"color: white\">Register successfully!!</h3>");
				RequestDispatcher rdlogin = request.getRequestDispatcher("index.html");
				rdlogin.include(request, response);
			}
			else {
				pw.print("<h3 style=\"color: white\">Account already exist!!</h3>");
				RequestDispatcher rdlogin = request.getRequestDispatcher("index.html");
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
