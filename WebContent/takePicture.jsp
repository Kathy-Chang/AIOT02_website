<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page  import="mqtt.mqtt,mqtt.subMsg"%>
	<% mqtt mq = new mqtt("tcp://localhost:1883","WebToRpi","takepic");
	   mq.publish();
	   
	   
	   
	subMsg smq = new subMsg("tcp://192.168.21.73","RpiToWeb","");
	smq.start();
 	String result = smq.messageshow();
	if(result != null && !result.isEmpty()) {
 		 synchronized(this) {
 			 if(result.equals("yes")) {
 				 request.getRequestDispatcher("home.html");
 			 }
 			 if(result.equals("no")) {
 				 request.getRequestDispatcher("index.jsp");
 			 }
 		 }
 	}
	%>
	
	
</body>
</html>