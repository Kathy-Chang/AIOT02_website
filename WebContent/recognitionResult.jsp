<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<%@ page  import="mqtt.mqtt,mqtt.subMsg"%>
	
	<% 
	subMsg smq = new subMsg("tcp://192.168.21.73","RpiToWeb",""); 
	smq.start();
	String result = smq.messageshow();
	if(result.equals("yes")){
	%>
		<jsp:forward page="home.html"></jsp:forward>
	<% 
	}
	%>
	<% 
	if(result.equals("no")){
	%>
		<jsp:forward page="index.jsp"></jsp:forward>
	<%
	}
	
	
	%>

</body>
</html>