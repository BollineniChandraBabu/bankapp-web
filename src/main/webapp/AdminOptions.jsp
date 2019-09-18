
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
	     
function viewBySubject(){
	 event.preventDefault();
	      var subjectcode = document.getElementById("subjectdetail").value;
	      var formData="subjectdetails=" +subjectcode.trim(); 
	         console.log(formData);
	     var url ="http://localhost:8080/web/FrontController/viewBySubject.do?"+formData;
	    $.get(url, function(response){
	        console.log(response);
	        var data=JSON.parse(response);
	        var content;
	  	 content="<div class=container><br><br><br><form method='post' onsubmit='viewBySubject()'><div class='form-group'><input type='text' class='form-control' name='subjectdetail' id='subjectdetail' placeholder='subject code' required='required'></div><div class='form-group' align=center><button type='submit' class='btn btn-primary btn-xs'>Search</button>&nbsp<button type='reset' class='btn btn-primary btn-xs'>clear</button></div>"      
	        if(data.length!=0)
	       {
	       for( let mark of data)
			{ 
	       content+="<br><br>Subject Id="+mark.subjects.id+"&nbsp&nbsp&nbspSubject Name="+mark.subjects.name+"<br><br><table border=1><tr><th>Student ID</th><th>Student Name</th><th>Marks</th><th>Grade</th></tr>";
			break;}
		
		for( let mark of data)
			{
			content +="<tr><td>"+mark.student.id +"</td><td>"+mark.student.name+"</td><td>"+mark.marks+ "</td><td>"+mark.grade+"</td></tr>";
			}

	       document.getElementById("viewdetails").innerHTML=content;
	     }
	     else
	     {
	      var url ="http://localhost:8080/web/FrontController/viewAvailableSubjects.do";
	    $.get(url, function(response){
	        console.log(response);
	        var data=JSON.parse(response);
	    	content+="<br><h3>subject not available.....<br></h3>select from available options...";
	     	content+="<table border=1><tr><th>Subject ID</th><th>Subject Name</th></tr>";
	     	for( let subject of data)
			{
			content +="<tr><td>"+subject.id +"</td><td>"+subject.name+"</td></tr>";
			}
	     	content+="</table>";
	     	
	     	
	      document.getElementById("viewdetails").innerHTML=content;
	      });}
	      
	     });
	     }
	     
function viewEmployees(){
    event.preventDefault();
var url ="http://localhost:8080/web/FrontController/viewEmployees.do";
    $.get(url, function(response){
        console.log(response);
       var data=JSON.parse(response);
       var content;
       content="<br><br><br><table border=1> <tr><th>ID</th><th>Name</th><th>Father Name</th><th>Email</th><th>Date of joining</th><th>Department</th></tr>";
       for( let users of data)
		{
			content+="<tr><td>"+users.id+"</td><td>"+users.name+"</td><td>"+users.fatherName+"</td><td>"+users.email+"</td><td>"+users.dateOfJoining+"</td><td>"+users.department.name+"</td></tr>";
           }
       content+="</table>"
       document.getElementById("viewdetails").innerHTML=content;
     });
    }
function viewStudents(){
    event.preventDefault();
var url ="http://localhost:8080/web/FrontController/viewStudents.do";
    $.get(url, function(response){
        console.log(response);
       var data=JSON.parse(response);
       var content;
       content="<br><br><br><table border=1> <tr><th>ID</th><th>Name</th><th>Father Name</th><th>Address</th><th>Date of Birth</th><th>Department</th></tr>";
       for( let users of data)
		{
			content+="<tr><td>"+users.registrationNumber+"</td><td>"+users.name+"</td><td>"+users.fatherName+"</td><td>"+users.Address+"</td><td>"+users.dateOfBirth+"</td><td>"+users.department.name+"</td></tr>";
           }
       content+="</table>"
       document.getElementById("viewdetails").innerHTML=content;
     });
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
	<a href="" onclick="viewGrade()">view grade range</a>
	<br>
	<a href="" onclick="viewTop()">view toper Score</a>
	<br>
	<a href="" onclick="viewBySubjects()">view by subject</a>
	<br>
	<a href="AddNewEmployee.jsp" >Add new Employee</a>
	<br>
	<a href="" onclick="viewEmployees()">view all Employee's</a>
	
	<br>
	<a href="AddNewStudent.jsp" >Add new Student</a>
	<br>
	<a href="" onclick="viewStudents()">view all students</a>
	<div id="output"></div>


</body>
</html>