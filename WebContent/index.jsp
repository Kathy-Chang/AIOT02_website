<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


<link rel="stylesheet" href="css/loginstyle.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/paho-mqtt/1.0.1/mqttws31.min.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<style>



</style>


</head>
<body>



<button id="sign-up">Sign in</button>
	
	<!-- <button id="face-sign-up" onclick="mqttToOpenRecognition()">Face Recognition</button> --> 
	<form target="blankFrame1" action="faceRecognition.jsp"><button id="face-sign-up">Face Recognition</button></form>
	
	
	
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
        <div style="margin-bottom: 5%;">
			<h2>Sign in</h2>
		</div>
		<iframe src="http://192.168.21.73:3030/" width="100%" height="45%" frameborder="0"  scrolling="no" ></iframe> 
		
		
		
		<div style="margin-bottom: 5%;margin-top: 5%;">
			
			
		    
			</form>
			<form action="takePicture" method="get">
		    <input type="submit" name="buttonTakePhoto" value="Take Photo" id="submit"/>
		    
			</form>
			
			
			
		</div>
		
		
		
		
		
		
		
		
		
		<p id="failText"></p>
		
		
		
		
		
		
	</div>
	
	<iframe src="about:blank" name="blankFrame1" id="blankFrame1" style="display : none;"></iframe>
	<iframe src="about:blank" name="blankFrame2" id="blankFrame2" style="display : none;"></iframe>
	<iframe src="about:blank" name="blankFrame3" id="blankFrame3" style="display : none;"></iframe>
	<iframe src="about:blank" name="blankFrame4" id="blankFrame3" style="display : none;"></iframe>
	<script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
	


	<script src="js/loginscript.js"></script>
	
</body>
</html>