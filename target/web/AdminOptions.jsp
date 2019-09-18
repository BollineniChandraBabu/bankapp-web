
<!DOCTYPE html>
<html>
<head>
<title>Grade Management system</title>
<link rel="icon" href="images/gms-logo.png" type="image/x-icon">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/viewGrades.js"></script>
<script>
function viewBySubjects(){
	 event.preventDefault();
	     console.log("erfrefrftrgtgtg");
  var content;
	 content="<div class=container><br><br><br><form method='post' onsubmit='viewBySubject()'><div class='form-group'><input type='text' class='form-control' name='subjectdetail' id='subjectdetail' placeholder='subject code' required='required'></div><div class='form-group' align=center><button type='submit' class='btn btn-primary btn-xs'>Search</button>&nbsp<button type='reset' class='btn btn-primary btn-xs'>clear</button></div>"      
document.getElementById("viewdetails").innerHTML=content;
	     }
</script>
</head>
<body>
	<h5 style="color: blue;" align=right>
		welcome ....
		<%out.print(session.getAttribute("email")); %>
	</h5>
	<br>
	<br>
	<a href="" onclick="viewGrade()">update grade range/view</a>
	<br>
	<a href="" onclick="viewTop()">view toper Score</a>
	<br>
	<a href="" onclick="viewallmarks()">view all marks</a>
	<br>
	<a href="" onclick="viewBySubjects()">view by subject</a>
	<br>
	<a href="" onclick="">view by Grade</a>
	<br>
	<a href="AddNewEmployee.jsp" >Add new Employee</a>
	<div id="output"></div>


</body>
</html>