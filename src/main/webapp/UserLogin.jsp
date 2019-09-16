
<!DOCTYPE html>
<html>
<head>
<title>Grade Management system</title>
<link rel="icon" href="images/gms-logo.png" type="image/x-icon">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="LoginHeader.jsp"></jsp:include>
	<h5 style="color: blue;" align=right>
		welcome ....
		<%out.print(session.getAttribute("email")); %>
	</h5>
	<br>
	<br>
	<a href="/upgradeGradeScore">update grade range/view</a>
	<br>
	<a href="/viewtoper" onclick=>view toper Score</a>
	<br>
	<a href="/viewallmarks">view all marks</a>
	<br>
	<a href="/AddNewEmployee"></a>
	<br>



</body>
</html>