<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>sign in</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">


<link rel="stylesheet" href="css/loginstyle.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>








</head>





	

<body >


	
	

	<button id="sign-up">Sign in</button>
	<button id="face-sign-up">Face Recognition</button>
	<!--<button id="face-sign-up">Face Recognition</button>-->
	
	<div id="sign-up-modal" class="">
		<a id="close-modal">&times;<a>
				<h2>Sign in</h2> <img src="images/009.jpg" alt="profile-image"
				width="200" />
				<form action="memberlogin">
					<input name="email" type="email" id="email"
						placeholder="email address" required="true" /> <input name="pass"
						type="password" id="password" placeholder="password"
						required="true" />
					<button type="submit" id="submit">Sign in</button>
					<p style="text-align: center">
						<a href="register.html">Create account</a>
					</p>
				</form>
				<button id="password-reveal">
					<img
						src="images/011.jpg"
						alt="eyeball" width="25px" />
				</button>
	</div>
	
	<div id="face-sign-up-modal" class="" >
        <!--<a id="face-close-modal">&times;<a>  -->
		<h2>Sign in</h2>
		<!--<iframe src="http://192.168.137.11:5438" width="100%" height="100%" frameborder="0" scrolling="auto"></iframe>  -->
		<!--<iframe src="http://192.168.36.136:5555" width="100%" height="100%" frameborder="0" scrolling="auto"></iframe>  -->
		<div id="refresh">
		
		<img  id="img" src="" height="50%" width="50%"/>
		<p id="mqttP"></p>
		
		</div>
		<%@ page import="mqtt.subMsg" %>
		<script type="text/javascript">
		
		<%for (int z = 1; z <= 300; z++){ %>
		var test = self.setInterval("t1()", 1000);
		console.log('<%=z%>');
		<%}%>
		
		function t1(){
			
			
			
			
			
			
			document.getElementById("img").src='data:image/jpeg;base64,' + '<% 
			subMsg test = new subMsg("tcp://192.168.21.73","test_03","");
			test.start(); 
			//test.messageshow(); 
			String img3 = test.messageshow(); 
			//out.print(img3);
			%>';
			console.log('<%=img3%>');
		}
		
		
		//startTimer();
		</script>
		
		
		
		
		
		
		
		
		
		<!--<img  id="img" src="startpicture.jpg" height="50%" width="50%"/>  -->
		
	</div>
	
	
	<script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
	


	<script src="js/loginscript.js"></script>




</body>

</html>
</html>