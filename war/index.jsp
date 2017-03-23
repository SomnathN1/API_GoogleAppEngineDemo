<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<title>Hello</title>
<link rel="stylesheet" href="css/style.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 <script src="js/common.js"></script>
</head>
<body>
	<form action="/api/hello">
		<label for="fname">Name</label> <input type="text" id="fname"
			name="firstname" placeholder="Your name..">
		<input type="button" value="Submit" id="callAPIButtonId">	
	</form>
	<div> API Response 
	     <div id="responseDivId"></div>
	</div>
	
</body>
</html>