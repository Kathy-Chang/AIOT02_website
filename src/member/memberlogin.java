package member;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;



import management.DAO;
import source.login;
import mqtt.mqtt;
import mqtt.subMsg;
import mqtt.PushCallback;

/**
 * Servlet implementation class login
 */
@WebServlet("/memberlogin")
public class memberlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO dao;
    /**
     * Default constructor. 
     */
    public memberlogin() {
    	super();
        // TODO Auto-generated constructor stub
    	dao = new DAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		mqtt mq = new mqtt();
//        mq.publish();
//        subMsg smq = new subMsg("tcp://192.168.36.91","test_03","");
//		smq.start();
//		String account = smq.messageshow();
//		System.out.print("test123"+smq.messageshow());
//		while(account == "") {
//			System.out.println("..........");
//			if(smq.messageshow()!=""){break;}
//			else {account = smq.messageshow();}
//		};
//		System.out.print("test123"+smq.messageshow());
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String account = request.getParameter("email");
		
		String password = request.getParameter("pass");
		
		login verify = dao.MemberLoginVerify(account, password);
		HttpSession session = request.getSession();
		
		String v_account = verify.getEmailaddress();
		String v_password = verify.getPassword();
		

		
		
		if(v_account.equals(account)) {
			RequestDispatcher rd = request.getRequestDispatcher("home.html");
			rd.forward(request, response);
			//Cookie ck = new Cookie("v_account", v_account);
			//mqtt mq = new mqtt("192.168.36.91","test_02","PI_PI");
			
			//response.addCookie(ck);
			
		}
		else {
			pw.print("<h3 style=\"color: white\">Account does not exist !!</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}

		
		
//		if(v_account.equals(account) && v_password.equals(password)) {
//			RequestDispatcher rd = request.getRequestDispatcher("home.html");
//			rd.forward(request, response);
//			Cookie ck = new Cookie("v_account", v_account);
//			//mqtt mq = new mqtt("192.168.36.91","test_02","PI_PI");
//			
//			response.addCookie(ck);
//			
//		}
//		else {
//			pw.print("<h3 style=\"color: white\">Account does not exist !!</h3>");
//			RequestDispatcher rd = request.getRequestDispatcher("index.html");
//			rd.include(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
