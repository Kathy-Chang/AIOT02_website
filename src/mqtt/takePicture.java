package mqtt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mqtt.mqtt;
import mqtt.subMsg;

/**
 * Servlet implementation class takePicture
 */
@WebServlet("/takePicture")
public class takePicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public takePicture() {
        super();
        // TODO Auto-generated constructor stub
        
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		mqtt mq = new mqtt("tcp://localhost:1883","WebToRpi","takepic");
    	mq.publish();
    	
    	

    	
    	
    	
    	subMsg smq = new subMsg("tcp://192.168.21.73","RpiToWeb","");
    	
    	System.out.print("1");
    	
    	smq.start();
    	
    	System.out.print("2");
    	
    	String result = smq.messageshow();
    	
    	while(result == null ||result.isEmpty() ) {
    		smq.start();
    		result = smq.messageshow();
    	}
    	
    	System.out.print("3");
    	
    	System.out.print("4"+result);
    	
    	System.out.print("5" + smq.messageshow());
    	
    	
    	
		
    	if(result != null || !result.isEmpty()) {
    		
    		if(result.equals("yes")) {
       		 System.out.print("OH YES!");
       		 RequestDispatcher rd = request.getRequestDispatcher("home.html");
       		 rd.forward(request,response);

	   		 }
	   		 if(result.equals("no")) {
   			 System.out.print("OH NO!");
   			 
   			 RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
   			 rd.forward(request,response);
   			 
   			
   			 
   		 }
    		
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
