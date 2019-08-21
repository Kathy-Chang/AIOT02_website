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
	<% mqtt mq = new mqtt("tcp://localhost:1883","WebToRpi","go");
	   mq.publish();
	%>
</body>
</html>